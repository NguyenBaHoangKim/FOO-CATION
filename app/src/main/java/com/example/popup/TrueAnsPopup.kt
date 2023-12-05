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

class TrueAnsPopup : DialogFragment(){
    private lateinit var correct_text: TextView
    private lateinit var correct_img: ImageView

    private lateinit var correcText: String
    private lateinit var correctImg: Bitmap
    var extras = ""

    private var quiz = QuizActivity()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quizz_correct, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn = view.findViewById<Button>(R.id.correct_btn)
        correct_text = view.findViewById(R.id.correct_text)
        correct_text.text = correcText
        correct_img = view.findViewById(R.id.correct_img)
        correct_img.setImageBitmap(correctImg)
        btn.setOnClickListener(nextQuestionListener)
    }
    private val nextQuestionListener = View.OnClickListener {
        (activity as QuizActivity).nextQuestion()
        dismiss()
    }
    fun setId(id: String) {
        extras = id
    }

    fun setData(_correcText: String, _correctImg: Bitmap){
        correcText = _correcText
        correctImg = _correctImg
    }
//    private fun fetchData() {
////        quizManager.getQuiz(id,{ data: List<QuizResp> ->
////            for (quiz in data) {
////                correct_text.text = quiz.description
////            }
////        }, { error ->
////            println(error)
////        })
//    }
//    fun setOnClick(id : String) {
//
//    }
}