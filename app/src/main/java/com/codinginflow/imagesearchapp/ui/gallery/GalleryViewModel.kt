package com.codinginflow.imagesearchapp.ui.gallery

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.codinginflow.imagesearchapp.data.UnsplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.client.*
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val repository: UnsplashRepository,
    state: SavedStateHandle
) : ViewModel() {

    private val currentQuery = state.getLiveData(CURRENT_QUERY, DEFAULT_QUERY)

    val photos = currentQuery.switchMap { queryString ->
        val ktorEnabled = true
        if (ktorEnabled) {
            repository.getKtorSearchResults(queryString).cachedIn(viewModelScope)
        } else {
            repository.getSearchResults(queryString).cachedIn(viewModelScope)
        }

    }

    fun searchPhotos(query: String) {
        currentQuery.value = query
    }

    companion object {

        private const val CURRENT_QUERY = "current_query"
        private const val DEFAULT_QUERY = "cats"
    }
}