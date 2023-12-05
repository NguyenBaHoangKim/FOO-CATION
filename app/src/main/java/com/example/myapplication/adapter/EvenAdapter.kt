package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.common.utils.Extensions.Companion.toBitMap
import com.example.model.Event
import com.example.model.EventResp
import com.example.myapplication.R

class EvenAdapter (var mList: List<Event>) :
    RecyclerView.Adapter<EvenAdapter.EvenViewHolder>()
{
    inner class EvenViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val image : ImageView = itemView.findViewById(R.id.image)
        val name : TextView = itemView.findViewById(R.id.even_name)
        val time : TextView = itemView.findViewById(R.id.even_time)
        val address : TextView = itemView.findViewById(R.id.even_addrest)
    }

    fun setFilteredList(mList: List<Event>){
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EvenViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.container_even, parent, false)
        return EvenViewHolder(view)
    }

    override fun onBindViewHolder(holder: EvenViewHolder, position: Int) {
        holder.image.setImageBitmap(mList[position].image)
        holder.name.text = mList[position].eventName
        holder.time.text = "Thời gian: " + mList[position].time
        holder.address.text = "Địa điểm: " + mList[position].address

    }

    override fun getItemCount(): Int {
        return mList.size
    }
}