package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.common.http.apiArtifact.ArtifactManager
import com.example.common.http.apiLocationResp.LocationRespManager
import com.example.common.utils.Extensions.Companion.toBitMap
import com.example.model.Artifact
import com.example.myapplication.adapter.artifactAdapter
import com.example.popup.InstructionPopup


class LocationDetail : AppCompatActivity() {
    private var locationRespManager = LocationRespManager()
    private var artifactManager = ArtifactManager()

    private var listArtifact = ArrayList<Artifact>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter : artifactAdapter
    private lateinit var name: TextView
    private lateinit var addrest: TextView
    private lateinit var img: ImageView
    private lateinit var inf: TextView
    private lateinit var fact: TextView
    private lateinit var btnStart : Button
    var id:String = ""
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.location_detail)
        name= findViewById(R.id.location_name)
        addrest = findViewById(R.id.address)
        img = findViewById(R.id.image_location)
        inf = findViewById(R.id.infor3)
        fact = findViewById(R.id.fact)
        recyclerView = findViewById(R.id.listArtifact)
        btnStart = findViewById(R.id.start)

        val extras: Bundle? = intent.extras
        if (extras != null) {
            id = extras.get("locationId").toString()
            println(id)
        }
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = artifactAdapter(listArtifact)
        recyclerView.adapter = adapter

//        fun setLocation(index: Int) {
//            name.text = list_name[index]
//            addrest.text = list_addresst[index]
//            img.setImageResource(R.drawable.place1)
//        }
        val showPopup = InstructionPopup()
        showPopup.show((this).supportFragmentManager, "")
        showPopup.setId(id)

        btnStart.setOnClickListener {
//            val intent = Intent("com.iphonik.chameleon.DiscoverActivity")
            val intent = Intent(this,DiscoverActivity::class.java)
            intent.putExtra("locationId", id)
            startActivity(intent)
        }

        val btn : Button = findViewById(R.id.button2)
        btn.setOnClickListener {
            finish()
        }
        fetchData()
    }

    private fun fetchData() {
        locationRespManager.getLocationWithId(id,{ data: com.example.model.LocationResp ->
            println(data.id + " " + data.name)
            name.text = data.name
            addrest.text = data.nameInMap
            img.setImageBitmap(data.image.data.toBitMap())
            inf.text = data.description
            fact.text = data.fact
            println(fact.text.toString())
        }, { error ->
            println(error)
        })

        artifactManager.getArtifactWithLocationId(id,{ data: List<Artifact> ->
            for (artifact in data) {
                listArtifact.add(Artifact(artifact.id,artifact.name,artifact.time,artifact.locationId,artifact.image,artifact.description))
            }
            println("them duoc artifact r")
        }, { error ->
            println(error)
        })
    }
}