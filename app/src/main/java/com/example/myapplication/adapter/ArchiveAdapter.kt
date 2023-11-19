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
import com.example.myapplication.search.Category

class ArchiveAdapter(var mList: List<ArchiveData>) :
    RecyclerView.Adapter<ArchiveAdapter.LocationViewHolder>() {
    private lateinit var onClickListener: (position: Int, model: ArchiveData) -> Unit

    inner class LocationViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val logo : ImageView = itemView.findViewById(R.id.logo)
        val title: TextView = itemView.findViewById(R.id.title)
        val btnStart : Button = itemView.findViewById(R.id.start)
        val id: String = ""
    }

    fun setFilteredList(mList: List<ArchiveData>){
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.archive_container, parent, false)
        val btn : Button = view.findViewById(R.id.start)
        return LocationViewHolder(view)
    }
    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val item = mList[position]
        holder.logo.setImageResource(mList[position].logo)
        holder.title.text = mList[position].title
        holder.btnStart.setOnClickListener {
            onClickListener(position, mList[position])
        }
    }

    fun setOnClickListener(onClickListener:  (position: Int, model: ArchiveData) -> Unit ) {
        this.onClickListener = onClickListener
    }

    interface OnClickListener{
        fun onClick(position: Int, model: ArchiveData)
    }
    override fun getItemCount(): Int {
        return mList.size
    }


}

