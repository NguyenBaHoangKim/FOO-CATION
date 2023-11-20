package com.example.common.http.apiQuiz

import com.example.model.Quiz
import retrofit2.Call
import retrofit2.http.GET

interface QuizApi {
    @GET("quizzes")
    fun getQuiz(): Call<List<Quiz>>
}