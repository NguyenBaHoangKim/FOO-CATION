package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Artifact
import com.example.model.SearchData
import com.example.myapplication.R

class artifactAdapter(val listArtifact : List<SearchData>) :
    RecyclerView.Adapter<artifactAdapter.ArtifactViewHolder>(){
    inner class ArtifactViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val logo : ImageView = itemView.findViewById(R.id.logo)
        val title : TextView = itemView.findViewById(R.id.title)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtifactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_artifact, parent, false)
        return ArtifactViewHolder(view)
    }
    override fun getItemCount(): Int {
        return listArtifact.size
    }

    override fun onBindViewHolder(holder: ArtifactViewHolder, position: Int) {
        holder.logo.setImageResource(listArtifact[position].logo)
        holder.title.text = listArtifact[position].title
    }
}