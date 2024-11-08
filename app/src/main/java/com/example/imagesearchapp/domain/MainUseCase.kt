package com.example.imagesearchapp.domain

import com.example.imagesearchapp.data.MainRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author nikhil borkar <nikhil.borkar@lenskart.in>
 * @version 1.0
 * Created 08 November, 2024
 */

@Singleton
class MainUseCase @Inject constructor(val repository: MainRepository) {

    fun getCountries() = repository.getCountries()



}