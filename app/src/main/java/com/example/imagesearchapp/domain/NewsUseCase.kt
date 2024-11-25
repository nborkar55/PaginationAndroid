package com.example.imagesearchapp.domain

import com.example.imagesearchapp.data.NewsRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author nikhil borkar <nikhil.borkar@lenskart.in>
 * @version 1.0
 * Created 25 November, 2024
 */
@Singleton
class NewsUseCase @Inject constructor(private val newsRepository: NewsRepository) {

    suspend fun getTopNews()= newsRepository.getTopNews()
}