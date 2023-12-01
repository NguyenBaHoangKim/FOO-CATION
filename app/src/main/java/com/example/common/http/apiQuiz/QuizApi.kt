package com.example.common.http.apiQuiz

import com.example.model.QuizResp
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface QuizApi {
    @GET("quizzes")
    fun getQuiz(
        @Query("locationId") locationId: String
    ): Call<List<QuizResp>>

    @POST("quizzes/{id}/answer/correct")
    fun quizCorrect(
        @Path("id") id: String
    ): Call<QuizResp>
}