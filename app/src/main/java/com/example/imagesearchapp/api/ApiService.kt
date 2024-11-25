package com.example.imagesearchapp.api

import com.example.imagesearchapp.BuildConfig
import com.example.imagesearchapp.data.model.TopNewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * @author nikhil borkar <nikhil.borkar@lenskart.in>
 * @version 1.0
 * Created 25 November, 2024
 */
interface ApiService {
    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @GET("/top-news?source-country=us&language=en&date=2024-05-29")
    fun getTopNews() : Call<TopNewsResponse>
}