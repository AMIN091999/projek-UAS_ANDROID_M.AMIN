package com.example.app_no_kontak

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Service_API {

    //List Data
    @GET("view_data.php")
    fun data() : Call<Halaman_ViewData>

    //Edit Data
    @FormUrlEncoded
    @POST("edit.php")
    fun edit(
        @Field("id") id: String,
        @Field("nm_kontak") nm_kontak: String,
        @Field("no_kontak") no_kontak: String
    ):Call<ResponInput>

    //Untuk Delete Data
    @FormUrlEncoded
    @POST("hapus.php")
    fun hapus(
        @Field("id") id: String,
    ):Call<ResponInput>

    //Tambah Data
    @FormUrlEncoded
    @POST("tambah.php")
    fun tambah(
        @Field("nm_kontak") nm_kontak: String,
        @Field("no_kontak") no_kontak: String
    ):Call<ResponInput>




}