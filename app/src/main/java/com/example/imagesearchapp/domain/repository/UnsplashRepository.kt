package com.example.imagesearchapp.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.imagesearchapp.data.model.UnsplashPhoto
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

interface UnsplashRepository {
    fun getSearchResults(query: String): LiveData<PagingData<UnsplashPhoto>>
    fun getKtorSearchResults(query: String) : LiveData<PagingData<UnsplashPhoto>>

}