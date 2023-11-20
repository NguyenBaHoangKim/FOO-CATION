package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.common.http.apiLocationResp.LocationRespManager
import com.example.common.utils.Extensions.Companion.toBitMap
import kotlin.reflect.typeOf


class LocationDetail : AppCompatActivity() {
    private var locationRespManager = LocationRespManager()
    private var mList = ArrayList<com.example.model.Location>()
    var list_name = arrayListOf<String>("Hồ Gươm", "Văn miếu Quốc tử giám","Hoàng thành Thăng Long", "Lăng Chủ tịch Hồ Chí Minh" )
    var list_addresst = arrayListOf<String>("123 Hoang Hoa Tham, Ba Dinh, Ha Noi", "255 Hoang Hoa Tham, Ba Dinh, Ha Noi")
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

        val extras: Bundle? = intent.extras
        if (extras != null) {
            id = extras.get("locationId").toString()
            println(id)
        }
//        fun setLocation(index: Int) {
//            name.text = list_name[index]
//            addrest.text = list_addresst[index]
//            img.setImageResource(R.drawable.place1)
//        }
        val btn : Button = findViewById(R.id.button2)
        btn.setOnClickListener {
            finish()
        }
        fetchData()
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