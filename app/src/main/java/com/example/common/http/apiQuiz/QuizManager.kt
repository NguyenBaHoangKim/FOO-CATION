package com.example.common.http.apiQuiz

import android.util.Log
import com.example.common.http.CustomApi
import com.example.model.QuizResp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuizManager {
    private val quizApi: QuizApi = CustomApi.client()
    fun getQuiz(onSuccess: (List<QuizResp>) -> Unit, onFailure: (error: String) -> Unit){
        quizApi.getQuiz().enqueue(object : Callback<List<QuizResp>?> {
            override fun onResponse(
                call: Call<List<QuizResp>?>,
                response: Response<List<QuizResp>?>
            ) {
                print(response.body())
                val responseBody = response.body() ?: return
                onSuccess(responseBody)
            }

            override fun onFailure(call: Call<List<QuizResp>?>, t: Throwable) {
                onFailure(t.message!!)
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }
}