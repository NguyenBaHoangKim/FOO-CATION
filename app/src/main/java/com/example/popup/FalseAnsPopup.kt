package com.example.popup

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.myapplication.QuizActivity
import com.example.myapplication.R


class FalseAnsPopup : DialogFragment(){
    private lateinit var wrong_text: TextView
    private lateinit var wrong_img: ImageView

    private lateinit var wrongext: String
    private lateinit var wrongImg: Bitmap
    var extras = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quiz_wrong, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        wrong_text = view.findViewById(R.id.wrong_text2)
        wrong_text.text = wrongext
        wrong_img = view.findViewById(R.id.wrong_img)
        wrong_img.setImageBitmap(wrongImg)
        
        val btn = view.findViewById<Button>(R.id.wrong_btn)
        btn.setOnClickListener(nextQuestionListener)
    }
    private val nextQuestionListener = View.OnClickListener {
        (activity as QuizActivity).nextQuestion()
        dismiss()
    }
    fun setId(id: String) {
        extras = id
    }
     fun setData(_wrongext: String, _wrongImg: Bitmap){
            wrongext = _wrongext
            wrongImg = _wrongImg
        }


}