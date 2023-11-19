package com.example.common.http.apiLocationResp

import android.util.Log
import com.example.common.http.CustomApi
import com.example.model.Location
import com.example.model.LocationResp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationRespManager {
    private val locationRespApi: LocationRespApi = CustomApi.client()
    fun getLocationResp(onSuccess: (List<LocationResp>) -> Unit, onFailure: (error: String) -> Unit){
        locationRespApi.getLocationResp().enqueue(object : Callback<List<LocationResp>?> {
            override fun onResponse(
                call: Call<List<LocationResp>?>,
                response: Response<List<LocationResp>?>
            ) {
                val responseBody = response.body() ?: return
                onSuccess(responseBody)
            }

            override fun onFailure(call: Call<List<LocationResp>?>, t: Throwable) {
                onFailure(t.message!!)
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }
}