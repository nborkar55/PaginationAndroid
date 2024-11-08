package com.example.imagesearchapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagesearchapp.data.model.Contries
import com.example.imagesearchapp.domain.MainUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author nikhil borkar <nikhil.borkar@lenskart.in>
 * @version 1.0
 * Created 08 November, 2024
 */

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: MainUseCase) : ViewModel() {

    private val _countries = MutableLiveData<List<Contries>?>()
    val countries: LiveData<List<Contries>?> = _countries


    fun getCountries() {
        viewModelScope.launch {
            useCase.getCountries(_countries)
        }
    }
}