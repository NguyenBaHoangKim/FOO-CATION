package com.example.myapplication.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.myapplication.MapsActivity
import com.example.myapplication.R


class LocationFragment : Fragment() {

    private lateinit var showMap: Button
//
//    val MainActivity:MainActivity?=null
//    fun LocationFragment(){}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_location, container, false)
        showMap = view.findViewById(R.id.showMap)
        showMap.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity,MapsActivity::class.java)
            startActivity(intent)
        })

        return view
    }
}