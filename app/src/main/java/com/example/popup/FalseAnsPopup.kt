package com.example.popup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.myapplication.QuizActivity
import com.example.myapplication.R


class FalseAnsPopup : DialogFragment(){
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
//    fun setOnClick(id : String) {
//
//    }



}