package com.example.app_no_kontak

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Halaman_Main_Adapter(
    val hasil: ArrayList<Halaman_ViewData.Data>,
    val listener: OnAdapterListener

):RecyclerView.Adapter<Halaman_Main_Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.halaman_main_adapter, parent, false)
    )

    override fun getItemCount():Int {
        return hasil.size
        //return body.size
    }

    override fun onBindViewHolder(holder: Halaman_Main_Adapter.ViewHolder, position: Int) {
        val data = hasil[position]

        holder.view.findViewById<TextView>(R.id.Nama_Kontak).text = data.nm_kontak
        holder.view.findViewById<TextView>(R.id.tv_No_Kontak).text = data.no_kontak

        holder.view.findViewById<TextView>(R.id.btn_update).setOnClickListener{
            listener.onUpdate(data)
        }

        holder.view.findViewById<TextView>(R.id.btn_delete).setOnClickListener{
            listener.onDelete(data)
        }
    }
    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)

    public fun setData(data: List<Halaman_ViewData.Data>){
        hasil.clear()
        hasil.addAll(data)
        notifyDataSetChanged()
    }

    interface OnAdapterListener{
        fun onUpdate(hasil: Halaman_ViewData.Data)
        fun onDelete(hasil: Halaman_ViewData.Data)
    }
}