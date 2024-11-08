package com.example.imagesearchapp.data

/**
 * @author nikhil borkar <nikhil.borkar@lenskart.in>
 * @version 1.0
 * Created 08 November, 2024
 */
sealed class ResponseState<T> {
    data class Success<T>(val data: T) : ResponseState<T>()
    data class Error<T>(val message: String) : ResponseState<T>()
    class Loading<T> : ResponseState<T>()
}