package com.example.imagesearchapp.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class KtorNetworkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        // Modify the request before it's sent
        val originalRequest = chain.request()
        val modifiedRequest = originalRequest.newBuilder()
            //   .addHeader("Authorization", "Bearer your_token")
            .build()

        val response = chain.proceed(modifiedRequest)

        // Modify the response before it's processed
        return response
    }

}