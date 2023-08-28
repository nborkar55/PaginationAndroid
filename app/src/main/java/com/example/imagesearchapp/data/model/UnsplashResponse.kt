package com.example.imagesearchapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UnsplashResponse(
    @SerialName("results")
    val results: List<UnsplashPhoto>
)