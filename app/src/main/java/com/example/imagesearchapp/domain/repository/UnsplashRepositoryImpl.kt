package com.example.imagesearchapp.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.imagesearchapp.api.UnsplashApi
import com.example.imagesearchapp.data.KtorUnsplashPagingSource
import com.example.imagesearchapp.data.UnsplashPagingSource
import com.example.imagesearchapp.data.model.UnsplashPhoto
import io.ktor.client.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepositoryImpl @Inject constructor(private val unsplashApi: UnsplashApi, private val httpClient: HttpClient) :
    UnsplashRepository {
    override fun getSearchResults(query: String): LiveData<PagingData<UnsplashPhoto>> {
       return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { UnsplashPagingSource(unsplashApi, query) }
        ).liveData
    }

    override fun getKtorSearchResults(query: String): LiveData<PagingData<UnsplashPhoto>> {
       return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { KtorUnsplashPagingSource(httpClient, query) }
        ).liveData
    }
}