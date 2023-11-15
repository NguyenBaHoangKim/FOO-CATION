package com.example.common.http.apiEven

import com.example.model.Event
import retrofit2.Call
import retrofit2.http.GET

interface EvensApi {
    @GET("even")
    fun getEvents(): Call<List<Event>>
}