package com.example.imagesearchapp.api

import com.example.imagesearchapp.data.UnsplashPhoto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UnsplashResponse(
    @SerialName("results")
    val results: List<UnsplashPhoto>
)