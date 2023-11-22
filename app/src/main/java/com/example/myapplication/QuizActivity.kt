package com.example.myapplication


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.common.http.apiQuiz.QuizManager
import com.example.common.utils.Extensions.Companion.toBitMap
import com.example.model.Quiz
import com.example.model.QuizResp
import com.example.myapplication.databinding.FragmentLocationBinding
import com.example.myapplication.databinding.QuizActivityBinding

class QuizActivity : AppCompatActivity() {
    private var quizManager = QuizManager()
    private var mList = ArrayList<Quiz>()

    private lateinit var binding: QuizActivityBinding
    private val question = arrayOf(mList)
    private val option = arrayOf(mList)
    private val correctAnswer = arrayOf(mList)

    var id = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = QuizActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val extras : Bundle? = intent.extras
        if (extras != null) {
            id = extras.get("key").toString()
            println(id)

        }
    }

    private fun fetchData() {
        quizManager.getQuiz(id.toString(),{ data: List<QuizResp> ->
        for (quiz in data) {
            mList.add(Quiz(quiz.id,id.toString(),quiz.question,quiz.point,quiz.correctAnwer,quiz.image.data.toBitMap(),quiz.answers))
             }
        }, { error ->
            println(error)
        })
    }


}