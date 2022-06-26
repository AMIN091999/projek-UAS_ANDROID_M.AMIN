package com.example.app_no_kontak

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class KoneksiDB {
    val endpoint: Service_API
        get() {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl("http://192.168.43.19/Api_Kontak/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(Service_API::class.java)
        }
}