package com.example.imagesearchapp.di

import com.example.imagesearchapp.api.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

/**
 * @author nikhil borkar <nikhil.borkar@lenskart.in>
 * @version 1.0
 * Created 08 November, 2024
 */
@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .baseUrl("https://restcountries.com/")
            .build()
    }

    @Provides
    fun getApiClientInstance( retrofit: Retrofit): ApiClient {
        return retrofit.create(ApiClient::class.java)
    }

}