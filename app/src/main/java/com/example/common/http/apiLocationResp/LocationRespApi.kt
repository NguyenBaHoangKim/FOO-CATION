package com.example.common.http.apiLocationResp

import com.example.model.Location
import com.example.model.LocationResp
import retrofit2.Call
import retrofit2.http.GET

interface LocationRespApi {
    @GET("locations")
    fun getLocationResp(): Call<List<LocationResp>>
}