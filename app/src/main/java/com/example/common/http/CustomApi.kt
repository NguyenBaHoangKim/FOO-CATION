package com.example.common.http

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CustomApi {
    val BASE_URL = "https://jsonplaceholder.typicode.com/"
    val MockApiURL = "http://192.168.88.60:8081/api/v1/"

    companion object {
        inline fun<reified T> client(): T {
            val customApi = CustomApi()
            val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(customApi.MockApiURL)
                .build()
            return retrofitBuilder.create(T::class.java)
        }
    }
}