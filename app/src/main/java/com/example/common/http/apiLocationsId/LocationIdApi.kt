package com.example.common.http.apiLocationsId

import com.example.model.Location
import com.example.model.LocationResp
import retrofit2.Call
import retrofit2.http.GET

interface LocationIdApi {
    @GET("locations/{id}")
    fun getLocationId(): Call<Location>
}