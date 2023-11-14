package com.example.common.api

import com.example.model.Event
import com.example.model.LoginRequest
import com.example.model.LoginResp
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {
    @POST("user/login")
    fun login(@Body body: LoginRequest): Call<LoginResp>

    @GET("even")
    fun getEvents(): Call<List<Event>>
}