package com.example.common.http.apiLocation

import com.example.model.Location
import retrofit2.Call
import retrofit2.http.GET

interface LocationApi {
    @GET("...")
    fun getLocation(): Call<List<Location>>
}