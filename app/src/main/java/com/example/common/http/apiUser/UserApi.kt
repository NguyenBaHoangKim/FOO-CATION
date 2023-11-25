package com.example.common.apiUser

import com.example.model.LoginRequest
import com.example.model.LoginResp
import com.example.model.Signup
import com.example.model.SignupRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("user/login")
    fun login(@Body body: LoginRequest): Call<LoginResp>

    @POST("user/register")
    fun signUp(@Body body: SignupRequest): Call<Signup>
}