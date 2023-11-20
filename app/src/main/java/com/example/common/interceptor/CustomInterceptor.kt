package com.example.common.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class CustomInterceptor(val token: String): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader("Authorization", token)
                .build()
        )
    }
}