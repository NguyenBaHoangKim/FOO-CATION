package com.example.common.http

import android.content.Context
import com.example.common.interceptor.AuthInterceptor
import com.example.common.utils.MyApp.Companion.context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CustomApi(val context: Context) {
    val apiURL = "http://localhost:8081g/api/v1/"
    companion object {
        inline fun <reified T> client(): T {
            val client = OkHttpClient.Builder()
                .addInterceptor(AuthInterceptor(context!!))
                .build()

            val customApi = CustomApi(context!!)
            val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(customApi.apiURL)
                .build()

            return retrofitBuilder.create(T::class.java)
        }
    }
}