package com.example.common.apiUser

import android.util.Log
import com.example.common.http.CustomApi
import com.example.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse

class UsersDataManager {
    private val userApi: UsersApi = CustomApi.client()
    fun getUsers(onSuccess: (User) -> Unit, onFailure: (error: String) -> Unit){
        userApi.getUsers().enqueue(object : Callback<User?> {
            override fun onResponse(
                call: Call<User?>,
                response: Response<User?>
            ) {
                println("get user info success")
                val responseBody = response.body() ?: return
                onSuccess(responseBody)
            }

            override fun onFailure(call: Call<User?>, t: Throwable) {
                println("get user info failure")
                onFailure(t.message!!)
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }

}