package com.example.imagesearchapp.presentation.adapters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagesearchapp.domain.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author nikhil borkar <nikhil.borkar@lenskart.in>
 * @version 1.0
 * Created 25 November, 2024
 */
@HiltViewModel
class NewsViewModel @Inject constructor(private val newsUseCase: NewsUseCase) : ViewModel() {
    fun getTopNews() = viewModelScope.launch { newsUseCase.getTopNews() }
}