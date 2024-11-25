package com.example.imagesearchapp.data.model


import com.google.gson.annotations.SerializedName

data class TopNewsResponse(
    @SerializedName("country")
    val country: String = "",
    @SerializedName("language")
    val language: String = "",
    @SerializedName("top_news")
    val topNews: List<TopNews> = listOf()
) {
    data class TopNews(
        @SerializedName("news")
        val news: List<News> = listOf()
    ) {
        data class News(
            @SerializedName("author")
            val author: String = "",
            @SerializedName("authors")
            val authors: List<String> = listOf(),
            @SerializedName("id")
            val id: Int = 0,
            @SerializedName("image")
            val image: String = "",
            @SerializedName("language")
            val language: String = "",
            @SerializedName("publish_date")
            val publishDate: String = "",
            @SerializedName("sentiment")
            val sentiment: Double = 0.0,
            @SerializedName("source_country")
            val sourceCountry: String = "",
            @SerializedName("summary")
            val summary: String = "",
            @SerializedName("text")
            val text: String = "",
            @SerializedName("title")
            val title: String = "",
            @SerializedName("url")
            val url: String = ""
        )
    }
}