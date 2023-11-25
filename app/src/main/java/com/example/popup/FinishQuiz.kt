package com.example.popup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.myapplication.QuizActivity
import com.example.myapplication.R

class FinishQuiz : DialogFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.finish_quiz, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn = view.findViewById<Button>(R.id.finishQuiz)

        btn.setOnClickListener(nextQuestionListener)
    }

    private val nextQuestionListener = View.OnClickListener {
        (activity as QuizActivity).finish()
        dismiss()
    }

}