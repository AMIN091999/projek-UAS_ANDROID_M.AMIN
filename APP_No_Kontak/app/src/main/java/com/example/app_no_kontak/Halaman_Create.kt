package com.example.app_no_kontak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Halaman_Create : AppCompatActivity() {

    private val api by lazy { KoneksiDB().endpoint }

    private lateinit var inNoKontak: EditText
    private lateinit var inNamaKontak: EditText
    private lateinit var btnSimpan: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.halaman_create)
        setupView()
        setupListener()
    }

    private fun setupView(){
        inNamaKontak = findViewById(R.id.in_NamaKontak)
        inNoKontak = findViewById(R.id.in_No_Kontak)
        btnSimpan = findViewById(R.id.btn_simpan)

    }

    private fun setupListener(){
        btnSimpan.setOnClickListener{
            if (inNoKontak.text.toString().isNotEmpty()&&inNamaKontak.text.toString().isNotEmpty()){

                api.tambah(inNamaKontak.text.toString(),inNoKontak.text.toString())
                    .enqueue(object :Callback<ResponInput>{
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

                        override fun onFailure(call: Call<ResponInput>, t: Throwable) { }
                    })
            }
            else{
                Toast.makeText(applicationContext,"Inputan Tidak Boleh Kosong",Toast.LENGTH_LONG).show()
            }
        }
    }
}