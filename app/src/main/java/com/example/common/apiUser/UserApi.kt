//package com.example.common.apiUser
//
//import com.example.model.LoginRequest
//import com.example.model.LoginResp
//import retrofit2.Call
//import retrofit2.http.Body
//import retrofit2.http.POST
//
//interface UserApi {
//    //Van dang test cai nay linh ta linh tinh cho login chu kp user để ly tên, id,...
//    @POST("user/login")
//    fun login(@Body body: LoginRequest): Call<LoginResp>
//}