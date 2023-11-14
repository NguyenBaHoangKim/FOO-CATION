package com.example.common.apiQuiz

import com.example.model.Quiz
import retrofit2.Call
import retrofit2.http.GET

interface QuizApi {
    @GET("...")
    fun getQuiz(): Call<List<Quiz>>
}