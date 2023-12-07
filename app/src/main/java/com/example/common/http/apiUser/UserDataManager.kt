package com.example.common.apiUser

import android.util.Log
import com.example.common.http.CustomApi
import com.example.model.LoginRequest
import com.example.model.LoginResp
import com.example.model.Repassword
import com.example.model.Signup
import com.example.model.SignupRequest
import com.example.model.User
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
                println(response.body())
                if(response.code() == 404 || response.body() == null) {
                    println("Dang nhap k thanh cong")
                    onFailure("")
                } else {
                    println(response.body())
                    println("Dang nhap thanh cong")
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
                println(response.errorBody()?.string())
                if(response.code() == 404 || response.body() == null) {
                    println(response.body())
                    println("Dang ky k thanh cong")
                    onFailure("")
                } else {
                    println(response.body())
                    println("Dang ky thanh cong")
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

    fun changePassword(repassword: Repassword,onSuccess: (User) -> Unit, onFailure: (error: String) -> Unit){
        usersApi.changePassword(repassword).enqueue(object : Callback<User?> {
            override fun onResponse(
                call: Call<User?>,
                response: Response<User?>
            ){
                println(response.errorBody()?.string())
                if (response.body() != null) {
                    println(response.body())
                    println("change pass user success")
                    val responseBody = response.body() ?: return
                    onSuccess(responseBody)
                }
                else {
                    println(response.code())
                    println("change password không thành công")
                    onFailure("")
                }
            }
            override fun onFailure(call: Call<User?>, t: Throwable) {
                println("huhu ")
                onFailure(t.message!!)
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }

    fun getUsers(onSuccess: (User) -> Unit, onFailure: (error: String) -> Unit){
        usersApi.getUsers().enqueue(object : Callback<User?> {
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