package com.example.common.api

import com.example.model.User
import retrofit2.Call
import retrofit2.http.GET

interface UserApi {
    @GET("User")
    fun getUsers(): Call<List<User>>
}