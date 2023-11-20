package com.example.common.http.apiLocationResp

import android.util.Log
import com.example.common.http.CustomApi
import com.example.model.LocationResp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationRespManager {
    private val locationRespApi: LocationRespApi = CustomApi.client()
    fun getLocationList(onSuccess: (List<LocationResp>) -> Unit, onFailure: (error: String) -> Unit){
        locationRespApi.getLocationList().enqueue(object : Callback<List<LocationResp>?> {
            override fun onResponse(
                call: Call<List<LocationResp>?>,
                response: Response<List<LocationResp>?>
            ) {
                val responseBody = response.body() ?: return
                onSuccess(responseBody)
            }

            override fun onFailure(call: Call<List<LocationResp>?>, t: Throwable) {
                println("k goi duoc map huhuuu")
                onFailure(t.message!!)
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }
    fun getLocationWithId(locationId: String, onSuccess: (LocationResp) -> Unit, onFailure: (error: String) -> Unit){
        locationRespApi.getLocation(locationId) .enqueue(object : Callback<LocationResp?> {
            override fun onResponse(
                call: Call<LocationResp?>,
                response: Response<LocationResp?>
            ) {
                val responseBody = response.body() ?: return
                onSuccess(responseBody)
            }
            override fun onFailure(call: Call<LocationResp?>, t: Throwable) {
                onFailure(t.message!!)
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }
}


