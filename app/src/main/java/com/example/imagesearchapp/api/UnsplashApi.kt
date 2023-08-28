package com.example.imagesearchapp.api

import com.example.imagesearchapp.BuildConfig
import com.example.imagesearchapp.data.model.UnsplashResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashApi {

    companion object {
        const val CLIENT_ID = BuildConfig.UNSPLASH_ACCESS_KEY
        const val UNSPLASH_STARTING_PAGE_INDEX = 1

    }

    @Headers("Accept-Version: v1", "Authorization: Client-ID $CLIENT_ID")
    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): UnsplashResponse
}