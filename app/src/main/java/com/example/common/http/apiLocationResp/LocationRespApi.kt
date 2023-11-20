package com.example.common.http.apiLocationResp

import com.example.model.LocationResp
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LocationRespApi {
    @GET("locations")
    fun getLocationList(): Call<List<LocationResp>>

    @GET("locations/{id}")
    fun getLocation(
        @Path("id") id: String
    ): Call<LocationResp>
}