package com.example.app_no_kontak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val api by lazy { KoneksiDB().endpoint}
    private lateinit var viewAdater: Halaman_Main_Adapter
    private lateinit var listNote: RecyclerView
    private lateinit var btnTambah : ExtendedFloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.halaman_utama)
        setupView()
        setupList()
        setupListener()

    }

    override fun onStart() {
        super.onStart()
        getData()
    }

    private fun setupView() {
        listNote = findViewById(R.id.recyclerView)
        btnTambah = findViewById(R.id.btn_tambah)
    }

    private fun setupListener() {
        btnTambah.setOnClickListener {
            startActivity(Intent(this,Halaman_Create::class.java))
        }
    }

    private fun setupList() {
        viewAdater = Halaman_Main_Adapter(arrayListOf(), object : Halaman_Main_Adapter.OnAdapterListener{
            override fun onUpdate(hasil: Halaman_ViewData.Data) {
                startActivity(
                    Intent(this@MainActivity,Halaman_Edit::class.java)
                        .putExtra("note",hasil)
                )
            }

            override fun onDelete(hasil: Halaman_ViewData.Data) {
                api.hapus(hasil.id!!)
                    .enqueue(object : Callback<ResponInput>{
                        override fun onResponse(
                            call: Call<ResponInput>,
                            response: Response<ResponInput>
                        ) {
                            if (response.isSuccessful){
                                val submit = response.body()
                                Toast.makeText(applicationContext,submit!!.pesan, Toast.LENGTH_SHORT).show()
                                getData()
                            }
                        }

                        override fun onFailure(call: Call<ResponInput>, t: Throwable) {
                        }

                    })
            }

        })
        listNote.adapter = viewAdater
    }

    private fun getData() {
        api.data().enqueue(object : Callback<Halaman_ViewData> {
            override fun onResponse(call: Call<Halaman_ViewData>, response: Response<Halaman_ViewData>) {
                if (response.isSuccessful) {
                    val listData = response.body()!!.hasil

                    //menampilkan data mysql di layout
                    viewAdater.setData(listData)

                }
            }

            override fun onFailure(call: Call<Halaman_ViewData>, t: Throwable) {
                Log.e("MainActivity-Log", t.toString())
            }

        })
    }
}