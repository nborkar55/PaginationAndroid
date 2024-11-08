package com.example.imagesearchapp.api

import com.example.imagesearchapp.data.ResponseState
import com.example.imagesearchapp.data.model.Contries
import retrofit2.Call
import retrofit2.http.GET

/**
 * @author nikhil borkar <nikhil.borkar@lenskart.in>
 * @version 1.0
 * Created 08 November, 2024
 */
interface ApiClient {
    @GET("/v3.1/all")
    fun getCountries(): Call<List<Contries>?>
}