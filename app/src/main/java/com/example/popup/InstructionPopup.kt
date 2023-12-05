package com.example.popup

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.myapplication.DiscoverActivity
import com.example.myapplication.R

class InstructionPopup : DialogFragment(){
    var extras = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.instruction_popup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnStart = view.findViewById<Button>(R.id.btnStart)
        val btnNo = view.findViewById<Button>(R.id.btnNo)

        btnStart.setOnClickListener() {
            Toast.makeText(context, "", Toast.LENGTH_LONG).show()
//            val intent = Intent("com.iphonik.chameleon.DiscoverActivity")
            val intent = Intent(activity,DiscoverActivity::class.java)
//             Passing the data to the
//             EmployeeDetails Activity
            intent.putExtra("locationId", extras)
            startActivity(intent)
            dismiss()
        }

        btnNo.setOnClickListener {
            dismiss()
        }

    }
    fun setId(id: String) {
        extras = id
    }

//    fun setOnClick(id : String) {
//
//    }
}