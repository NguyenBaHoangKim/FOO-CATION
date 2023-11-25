package com.example.common.apiUser

import android.util.Log
import com.example.common.http.CustomApi
import com.example.model.LoginRequest
import com.example.model.LoginResp
import com.example.model.Signup
import com.example.model.SignupRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserDataManager {
    private val usersApi: UserApi = CustomApi.client()
    fun login(loginInfo: LoginRequest, onSuccess: (LoginResp) -> Unit, onFailure: (error: String) -> Unit){
        usersApi.login(loginInfo).enqueue(object : Callback<LoginResp?> {
            override fun onResponse(
                call: Call<LoginResp?>,
                response: Response<LoginResp?>
            ) {
                println(response.code())
                if(response.code() == 404 || response.body() == null) {
                    println("Dang nhap k thanh cong")
                    onFailure("")
                } else {
                    println(response.body())
                    val responseBody = response.body() ?: return
                    onSuccess(responseBody)
                }
            }

            override fun onFailure(call: Call<LoginResp?>, t: Throwable) {
                println("huhu ")
                onFailure(t.message!!)
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }

    fun signUp(signup: SignupRequest,onSuccess: (Signup) -> Unit, onFailure: (error: String) -> Unit){
        usersApi.signUp(signup).enqueue(object : Callback<Signup?> {
            override fun onResponse(
                call: Call<Signup?>,
                response: Response<Signup?>
            ) {
                println(response.code())
                if(response.code() != 200 || response.body() == null) {
                    println("Dang ky k thanh cong")
                    onFailure("")
                } else {
                    println(response.body())
                    val responseBody = response.body() ?: return
                    onSuccess(responseBody)
                }
            }
            override fun onFailure(call: Call<Signup?>, t: Throwable) {
                println("huhu ")
                onFailure(t.message!!)
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }

}