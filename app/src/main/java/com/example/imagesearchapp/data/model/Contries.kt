package com.example.imagesearchapp.data.model

import com.google.gson.annotations.SerializedName


/**
 * @author nikhil borkar <nikhil.borkar@lenskart.in>
 * @version 1.0
 * Created 08 November, 2024
 */
data class Contries(
    @SerializedName("flags")
    val flags: Flags,
    @SerializedName("name")
    val name: Name
) {
    data class Flags(
        @SerializedName("png")
        val png: String,
        @SerializedName("svg")
        val svg: String
    )

    data class Name(
        @SerializedName("common")
        val common: String
    )
}
