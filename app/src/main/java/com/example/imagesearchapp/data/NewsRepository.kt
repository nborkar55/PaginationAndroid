package com.example.imagesearchapp.data

import com.example.imagesearchapp.api.ApiService
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author nikhil borkar <nikhil.borkar@lenskart.in>
 * @version 1.0
 * Created 25 November, 2024
 */

@Singleton
class NewsRepository @Inject constructor(val apiService: ApiService){

    suspend fun getTopNews() = apiService.getTopNews()
}