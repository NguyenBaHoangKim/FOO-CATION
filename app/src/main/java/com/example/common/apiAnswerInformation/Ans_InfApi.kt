package com.example.common.apiSearchData

import com.example.model.AnswerInformation
import retrofit2.Call
import retrofit2.http.GET

interface Ans_InfApi {
    @GET("...")
    fun getAns_Inf(): Call<List<AnswerInformation>>
}