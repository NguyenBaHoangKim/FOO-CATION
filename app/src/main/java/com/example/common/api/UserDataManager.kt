package com.example.common.api

import android.util.Log
import com.example.common.http.CustomApi
import com.example.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse

class UserDataManager {
    private val userApi: UserApi = CustomApi.client()
    fun getUsers(onSuccess: (List<User>) -> Unit, onFailure: (error: String) -> Unit){
        userApi.getUsers().enqueue(object : Callback<List<User>?> {
            override fun onResponse(
                call: Call<List<User>?>,
                response: Response<List<User>?>
            ) {
                print(response.body())
                val responseBody = response.body() ?: return
                onSuccess(responseBody)
            }

            override fun onFailure(call: Call<List<User>?>, t: Throwable) {
                onFailure(t.message!!)
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }
}