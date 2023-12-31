package com.example.myapplication


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.common.http.apiQuiz.QuizManager
import com.example.model.AnswerResp
import com.example.model.Quiz
import com.example.model.QuizResp
import com.example.myapplication.databinding.QuizActivityBinding
import com.example.popup.FalseAnsPopup
import com.example.popup.FinishQuiz
import com.example.popup.TrueAnsPopup

class QuizActivity : AppCompatActivity() {
    private var quizManager = QuizManager()
    private var mList = ArrayList<Quiz>()

//    public lateinit var correctText: String
//    public lateinit var anh: Bitmap

    private lateinit var binding: QuizActivityBinding

    private var questionIndex = 0;
    var id = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = QuizActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras: Bundle? = intent.extras
        if (extras != null) {
            id = extras.getString("locationId", "")
            println(id)
        }

        binding.button3.setOnClickListener {
            finish()
        }
        fetchData()
    }

    private fun fetchData() {
        quizManager.getQuiz(id,{ data: List<QuizResp> ->
            for (quiz in data) {
                if (quiz.answers.size >= 3) {
                    mList.add(Quiz(quiz))
                }
                println("id quiz location: " + quiz.locationId)
            }
            if (mList.size == 0) {
                Toast.makeText(this,"Bạn chưa thể tham gia quizz này", Toast.LENGTH_SHORT).show()
                finish()
            }
            else {
                setupQuestionForIndex(questionIndex)
            }
        }, { error ->
            println(error)
        })
    }

    private fun updatePoint(quizid: String, answerId: String) {
        quizManager.quizCorrect(quizid, answerId ,{ data: AnswerResp ->
            if (data.isCorrect == true) {
                correctAns()
            }
            else {
                wrongAns()
            }
        }, { error ->
            println(error)
        })
    }

    fun setupQuestionForIndex(index: Int) {
        val quiz = mList[index]
        binding.ans1.text = quiz.answers[0].answer
        binding.ans2.text = quiz.answers[1].answer
        binding.ans3.text = quiz.answers[2].answer
        binding.ans4.text = quiz.answers[3].answer
        binding.qs.text = quiz.question
        binding.imageView5.setImageBitmap(quiz.image)
        binding.score.text = "${index+1}/${mList.size} câu"
        binding.ans1.setOnClickListener {
            updatePoint(mList[index].id,mList[index].answers[0].id)
        }
        binding.ans2.setOnClickListener {
            updatePoint(mList[index].id,mList[index].answers[1].id)
        }
        binding.ans3.setOnClickListener {
            updatePoint(mList[index].id,mList[index].answers[2].id)
        }
        binding.ans4.setOnClickListener {
            updatePoint(mList[index].id,mList[index].answers[3].id)
        }
    }

    private fun correctAns() {
        val popUp = TrueAnsPopup()
        popUp.setData(mList[questionIndex].description, mList[questionIndex].image)
        popUp.show((this as AppCompatActivity).supportFragmentManager, "")
    }

    private fun wrongAns() {
        val popUp = FalseAnsPopup()
        popUp.setData(mList[questionIndex].description, mList[questionIndex].image)
        popUp.show((this as AppCompatActivity).supportFragmentManager, "")
    }

    fun nextQuestion() {
        questionIndex++
        if(questionIndex >= mList.size) {
            finishQuiz()
        } else {
            setupQuestionForIndex(questionIndex)
        }
    }
    fun finishQuiz() {
        val popUp = FinishQuiz()
        popUp.show((this as AppCompatActivity).supportFragmentManager, "")
    }

}
