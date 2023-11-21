package com.example.common.http.apiEven

import com.example.model.EventResp
import retrofit2.Call
import retrofit2.http.GET

interface EvensApi {
    @GET("events")
    fun getEvents(): Call<List<EventResp>>
}