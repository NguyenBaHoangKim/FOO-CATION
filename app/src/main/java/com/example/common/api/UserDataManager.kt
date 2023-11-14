package com.example.common.api

import android.util.Log
import com.example.common.http.CustomApi
import com.example.model.Event
import com.example.model.LoginRequest
import com.example.model.LoginResp
import com.example.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserDataManager {
    private val userApi: UserApi = CustomApi.client()
    fun login(loginInfo: LoginRequest, onSuccess: (LoginResp) -> Unit, onFailure: (error: String) -> Unit){
        userApi.login(loginInfo).enqueue(object : Callback<LoginResp?> {
            override fun onResponse(
                call: Call<LoginResp?>,
                response: Response<LoginResp?>
            ) {
                print(response.body())
                val responseBody = response.body() ?: return
                onSuccess(responseBody)
            }

            override fun onFailure(call: Call<LoginResp?>, t: Throwable) {
                onFailure(t.message!!)
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }

    fun getEvents( onSuccess: (List<Event>) -> Unit, onFailure: (error: String) -> Unit) {
        userApi.getEvents().enqueue(object : Callback<List<Event>?> {
            override fun onResponse(call: Call<List<Event>?>, response: Response<List<Event>?>) {
                print(response.body())
                val responseBody = response.body() ?: return
                onSuccess(responseBody)
            }


            override fun onFailure(call: Call<List<Event>?>, t: Throwable) {
                onFailure(t.message!!)
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        }
        )
    }
}

