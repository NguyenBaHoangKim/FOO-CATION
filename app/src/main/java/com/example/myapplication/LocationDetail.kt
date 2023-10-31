package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class LocationDetail : Fragment(){
    var list_name = arrayListOf<String>("Hồ Gươm", "Văn miếu Quốc tử giám","Hoàng thành Thăng Long", "Lăng Chủ tịch Hồ Chí Minh" )
    var list_addresst = arrayListOf<String>("123 Hoang Hoa Tham, Ba Dinh, Ha Noi", "255 Hoang Hoa Tham, Ba Dinh, Ha Noi")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.location_detail, container, false)
        var name: TextView = view.findViewById(R.id.location_name)
        var addrest: TextView = view.findViewById(R.id.address)
        var img: ImageView = view.findViewById(R.id.image_location)
        fun setLocation(index: Int) {
            name.text = list_name[index]
            addrest.text = list_addresst[index]
            img.setImageResource(R.drawable.place1)
        }
        return view
    }
}
