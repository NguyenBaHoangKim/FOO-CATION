package com.example.common.http.apiQuiz

import com.example.model.QuizResp
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface QuizApi {
    @GET("quizzes")
    fun getQuiz(
        @Path("locationId") locationId: String
    ): Call<List<QuizResp>>
}