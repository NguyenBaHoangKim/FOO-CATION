package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.common.http.apiLocationResp.LocationRespManager
import com.example.common.utils.Extensions.Companion.toBitMap
import com.example.model.Artifact
import com.example.model.SearchData
import com.example.myapplication.adapter.SearchAdapter
import com.example.myapplication.adapter.artifactAdapter
import com.example.popup.InstructionPopup
import com.example.popup.QuizPopup
import kotlin.reflect.typeOf


class LocationDetail : AppCompatActivity() {
    private var locationRespManager = LocationRespManager()
    private var mList = ArrayList<com.example.model.Location>()
    var list_name = arrayListOf<String>("Hồ Gươm", "Văn miếu Quốc tử giám","Hoàng thành Thăng Long", "Lăng Chủ tịch Hồ Chí Minh" )
    var list_addresst = arrayListOf<String>("123 Hoang Hoa Tham, Ba Dinh, Ha Noi", "255 Hoang Hoa Tham, Ba Dinh, Ha Noi")
    private var listArtifact = ArrayList<SearchData>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter : artifactAdapter
    private lateinit var name: TextView
    private lateinit var addrest: TextView
    private lateinit var img: ImageView
    private lateinit var inf: TextView
    var id:String = ""
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.location_detail)
        name= findViewById(R.id.location_name)
        addrest = findViewById(R.id.address)
        img = findViewById(R.id.image_location)
        inf = findViewById(R.id.infor3)
        recyclerView = findViewById(R.id.listArtifact)

        val extras: Bundle? = intent.extras
        if (extras != null) {
            id = extras.get("locationId").toString()
            println(id)
        }
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = artifactAdapter(listArtifact)
        recyclerView.adapter = adapter

        addDataArtifact()
//        fun setLocation(index: Int) {
//            name.text = list_name[index]
//            addrest.text = list_addresst[index]
//            img.setImageResource(R.drawable.place1)
//        }
        val showPopup = InstructionPopup()
        showPopup.show((this).supportFragmentManager, "")
        showPopup.setId(id)

        val btn : Button = findViewById(R.id.button2)
        btn.setOnClickListener {
            finish()
        }
        fetchData()
    }

    private fun addDataArtifact() {
        listArtifact.add(SearchData("","Bia Văn Miếu Quốc Tử Giám", R.drawable.artifact1, ""))
        listArtifact.add(SearchData("","Cầu Thê Húc", R.drawable.artifact2, ""))
        listArtifact.add(SearchData("","Tháp Rùa", R.drawable.artifact3, ""))
        listArtifact.add(SearchData("","Con Dấu Triều Nguyễn", R.drawable.artifact4,""))
        listArtifact.add(SearchData("","Tượng Nghê Đồng (Thế kỉ XVI)", R.drawable.artifact5, ""))
    }

    private fun fetchData() {
        locationRespManager.getLocationWithId(id,{ data: com.example.model.LocationResp ->
            println(data.id + data.name)
            name.text = data.name
            addrest.text = data.nameInMap
            img.setImageBitmap(data.image.data.toBitMap())
            inf.text = data.description
        }) { error ->
            println(error)
        }
    }
}