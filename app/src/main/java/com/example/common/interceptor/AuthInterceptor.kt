package com.example.common.interceptor

import android.content.Context
import android.content.Intent
import com.example.common.utils.MyApp
import com.example.common.utils.UserSessionManager
import com.example.myapplication.LogInActivity
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val sessionManager = UserSessionManager(MyApp.context!!)
        val request = chain.request()
        val authRequest = request.newBuilder()
            .addHeader("Authorization", "Bearer ${sessionManager.getInfo("accessToken")}")
            .build()

        val response = chain.proceed(authRequest)
        if (response.code() == 401 || response.code() == 403) {
            val intent = Intent(context, LogInActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
        return response
    }
}