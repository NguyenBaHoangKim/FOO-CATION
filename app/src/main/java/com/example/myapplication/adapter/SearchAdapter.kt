package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.common.utils.Extensions.Companion.toBitMap
import com.example.model.SearchsData
import com.example.myapplication.R

class SearchAdapter(var mList: SearchsData) :
    RecyclerView.Adapter<SearchAdapter.LocationViewHolder>() {
    inner class LocationViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val logo : ImageView = itemView.findViewById(R.id.logo)
        val title: TextView = itemView.findViewById(R.id.title)

    }

    fun setFilteredList(mList: SearchsData){
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.data_searching, parent, false)

        return LocationViewHolder(view)
    }
    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.logo.setImageBitmap(mList.artifacts[position].image.data.toBitMap())
        holder.title.text = mList.artifacts[position].name
    }
    override fun getItemCount(): Int {
        return mList.artifacts.size + mList.locations.size
    }
}