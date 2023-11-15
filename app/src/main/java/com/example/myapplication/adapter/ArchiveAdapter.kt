package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.model.ArchiveData
import com.example.myapplication.R

class ArchiveAdapter(var mList: List<ArchiveData>) :
    RecyclerView.Adapter<ArchiveAdapter.LocationViewHolder>() {
    private var onClickListener: OnClickListener? = null
    inner class LocationViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val logo : ImageView = itemView.findViewById(R.id.logo)
        val title: TextView = itemView.findViewById(R.id.title)
        val btnStart : Button = itemView.findViewById(R.id.start)
        var id = 0
    }

    fun setFilteredList(mList: List<ArchiveData>){
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.archive_container, parent, false)

        return LocationViewHolder(view)
    }
    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val item = mList[position]
        holder.logo.setImageResource(mList[position].logo)
        holder.title.text = mList[position].title
        holder.id = mList[position].id
        holder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, item )
            }
        }
    }
    override fun getItemCount(): Int {
        return mList.size
    }
    interface OnClickListener {
        fun onClick(position: Int, model: ArchiveData)
    }
}