package com.example.common.http.apiLocation

import android.util.Log
import com.example.common.http.CustomApi
import com.example.model.Location
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationManager {
    private val locationApi: LocationApi = CustomApi.client()
    fun getLocation(onSuccess: (List<Location>) -> Unit, onFailure: (error: String) -> Unit){
        locationApi.getLocation().enqueue(object : Callback<List<Location>?> {
            override fun onResponse(
                call: Call<List<Location>?>,
                response: Response<List<Location>?>
            ) {
                print(response.body())
                val responseBody = response.body() ?: return
                onSuccess(responseBody)
            }

            override fun onFailure(call: Call<List<Location>?>, t: Throwable) {
                onFailure(t.message!!)
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }
}