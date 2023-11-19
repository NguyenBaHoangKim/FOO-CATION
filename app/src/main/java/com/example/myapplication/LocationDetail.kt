package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class LocationDetail : AppCompatActivity() {
    var list_name = arrayListOf<String>("Hồ Gươm", "Văn miếu Quốc tử giám","Hoàng thành Thăng Long", "Lăng Chủ tịch Hồ Chí Minh" )
    var list_addresst = arrayListOf<String>("123 Hoang Hoa Tham, Ba Dinh, Ha Noi", "255 Hoang Hoa Tham, Ba Dinh, Ha Noi")
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.location_detail)
        var name: TextView = findViewById(R.id.location_name)
        var addrest: TextView = findViewById(R.id.address)
        var img: ImageView = findViewById(R.id.image_location)
        fun setLocation(index: Int) {
            name.text = list_name[index]
            addrest.text = list_addresst[index]
            img.setImageResource(R.drawable.place1)
        }
        val btn : Button = findViewById(R.id.button2)
        btn.setOnClickListener {
            finish()
        }
    }
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val view = inflater.inflate(R.layout.location_detail, container, false)
//        var name: TextView = view.findViewById(R.id.location_name)
//        var addrest: TextView = view.findViewById(R.id.address)
//        var img: ImageView = view.findViewById(R.id.image_location)
//        fun setLocation(index: Int) {
//            name.text = list_name[index]
//            addrest.text = list_addresst[index]
//            img.setImageResource(R.drawable.place1)
//        }
//        return view
//    }
}