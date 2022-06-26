package com.example.app_no_kontak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Halaman_Edit : AppCompatActivity() {
    private val api by lazy { KoneksiDB().endpoint }
    private lateinit var edtNamaKontak: EditText
    private lateinit var edtNoKontak: EditText


    private lateinit var btnEdit: MaterialButton
    private val note by lazy {intent.getSerializableExtra("note") as Halaman_ViewData.Data }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.halaman_edit)
        setupView()
        setupListener()
    }
    private fun setupView(){
        edtNamaKontak = findViewById(R.id.edt_NamaKontak)
        edtNoKontak = findViewById(R.id.edt_No_Kontak)
        btnEdit = findViewById(R.id.btn_simpan)

        edtNamaKontak.setText(note.nm_kontak)
        edtNoKontak.setText(note.no_kontak)


    }
    private fun setupListener(){

        btnEdit.setOnClickListener{
            api.edit(note.id!!, edtNamaKontak.text.toString(), edtNoKontak.text.toString())
                .enqueue(object : Callback<ResponInput>{
                    override fun onResponse(
                        call: Call<ResponInput>,
                        response: Response<ResponInput>
                    ) {
                        if (response.isSuccessful){
                            val submit = response.body()
                            Toast.makeText(applicationContext,submit!!.pesan,Toast.LENGTH_SHORT).show()
                            finish()
                        }
                    }

                    override fun onFailure(call: Call<ResponInput>, t: Throwable) {

                    }

                })
        }
    }
}

