package com.example.app_no_kontak

import java.io.Serializable

data class Halaman_ViewData (
    val hasil : List<Data>
){
    data class Data(
        val id:String?,
        val nm_kontak:String?,
        val no_kontak:String?
    ): Serializable
}