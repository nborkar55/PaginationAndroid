package com.example.imagesearchapp.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class KtorAuthInterceptor:Interceptor {
    private val TAG: String?= KtorNetworkInterceptor::class.java.simpleName

    override fun intercept(chain: Interceptor.Chain): Response {
        // Modify the request before it's sent
        val originalRequest = chain.request()
        val modifiedRequest = originalRequest.newBuilder()
            //   .addHeader("Authorization", "Bearer your_token")
            .build()

        val response = chain.proceed(modifiedRequest)
        Log.d(TAG, "intercept nik: ${response.code} resp: ${response.body}")
        when(response.code){
            in 200..299 -> {
            }
            in 200..299 -> {
                // Successful response, do nothing special
            }
            401 -> {
                // Unauthorized, handle accordingly
            }
            404 -> {
                // Not found, handle accordingly
            }
            else->{

            }
        }
        // Modify the response before it's processed
        return response
    }
}