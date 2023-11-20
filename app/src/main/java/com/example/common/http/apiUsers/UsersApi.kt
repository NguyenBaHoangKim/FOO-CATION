package com.example.common.apiUser

import com.example.model.User
import retrofit2.Call
import retrofit2.http.GET

interface UsersApi {
    //Van dang test cai nay linh ta linh tinh
    @GET("user")
    fun getUsers(): Call<User>
}