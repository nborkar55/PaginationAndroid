package com.example.imagesearchapp.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.imagesearchapp.domain.repository.UnsplashRepository
import com.example.imagesearchapp.data.model.UnsplashPhoto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchResultUseCase @Inject constructor(val repository: UnsplashRepository){

    operator fun invoke(queryString: String) : LiveData<PagingData<UnsplashPhoto>>{
            val ktorEnabled = true
           return if (ktorEnabled) {
                repository.getKtorSearchResults(queryString)
            } else {
                repository.getSearchResults(queryString)
            }
    }
}