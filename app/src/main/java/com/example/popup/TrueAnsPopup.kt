package com.example.popup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.common.http.apiQuiz.QuizManager
import com.example.model.Quiz
import com.example.model.QuizResp
import com.example.myapplication.QuizActivity
import com.example.myapplication.R

class TrueAnsPopup : DialogFragment(){
    private var quizManager = QuizManager()
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
        btn.setOnClickListener(nextQuestionListener)

    }
    private val nextQuestionListener = View.OnClickListener {
        (activity as QuizActivity).nextQuestion()
        dismiss()
    }
    fun setId(id: String) {
        extras = id
    }

    private fun fetchData() {
        quizManager.getQuiz(id,{ data: List<QuizResp> ->
            for (quiz in data) {
                correct_text.text = quiz.description
            }
        }, { error ->
            println(error)
        })
    }
//    fun setOnClick(id : String) {
//
//    }



}