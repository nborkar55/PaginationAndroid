package com.codinginflow.imagesearchapp.api

import com.codinginflow.imagesearchapp.data.UnsplashPhoto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UnsplashResponse(
    @SerialName("results")
    val results: List<UnsplashPhoto>
):java.io.Serializable