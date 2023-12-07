package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Location
import com.example.myapplication.R

class SearchLocationAdapter(var mList: List<Location>) :
    RecyclerView.Adapter<SearchLocationAdapter.LocationViewHolder>() {
    inner class LocationViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val logo : ImageView = itemView.findViewById(R.id.logo)
        val title: TextView = itemView.findViewById(R.id.title)

    }

    fun setFilteredList(mList: List<Location>){
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.data_searching, parent, false)

        return LocationViewHolder(view)
    }
    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.logo.setImageBitmap(mList[position].image)
        holder.title.text = mList[position].name

//        holder.logo.setImageBitmap(mList.locations[position].image)
//        holder.title.text = mList.locations[position].name
    }
    override fun getItemCount(): Int {
        return mList.size
    }
}