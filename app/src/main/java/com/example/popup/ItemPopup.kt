package com.example.popup

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.myapplication.DiscoverActivity
import com.example.myapplication.R

class ItemPopup : DialogFragment(){
    @SuppressLint("MissingInflatedId")

    private lateinit var imageItem : ImageView
    private lateinit var imageItemBitmap: Bitmap
    private lateinit var imagePopupBitmap: Bitmap
    private var index : Int? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.item_popup, container, false)
        val imagePopup : ImageView = view.findViewById(R.id.item)
        val btnGetItem = view.findViewById<Button>(R.id.btnGetItem)

        imagePopup.setImageBitmap(imagePopupBitmap)
        btnGetItem.setOnClickListener {
            dismiss()
        }
        return view
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//    }
    fun setImagePopup(bitmap: Bitmap) {
        imagePopupBitmap = bitmap
        println("okeee")
    }
//    fun createItem(image : ImageView, bitmap: Bitmap) {
//        image?.setImageBitmap(bitmap)
//    }

}