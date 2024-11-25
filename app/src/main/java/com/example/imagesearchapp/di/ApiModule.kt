package com.example.imagesearchapp.di

import com.example.imagesearchapp.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author nikhil borkar <nikhil.borkar@lenskart.in>
 * @version 1.0
 * Created 25 November, 2024
 */

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.newscatcherapi.com/v2")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

}