package com.example.common.http.apiEven

import android.util.Log
import com.example.common.http.CustomApi
import com.example.model.EventResp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventsManager {
    private val evensApi: EvensApi = CustomApi.client()
    fun getEvents(onSuccess: (List<EventResp>) -> Unit, onFailure: (error: String) -> Unit) {
        evensApi.getEvents().enqueue(object : Callback<List<EventResp>?> {
            override fun onResponse(call: Call<List<EventResp>?>, response: Response<List<EventResp>?>) {
                print(response.body())
                val responseBody = response.body() ?: return
                onSuccess(responseBody)
            }
            override fun onFailure(call: Call<List<EventResp>?>, t: Throwable) {
                onFailure(t.message!!)
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        }
        )
    }
}

