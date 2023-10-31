package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class PopupStartFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_popup_start, container, false)
        val btnStart : Button = view.findViewById(R.id.btnStart)
        btnStart.setOnClickListener {
            showdialog_popup_start()
        }
        return view
    }
    private fun showdialog_popup_start() {
    }
}
