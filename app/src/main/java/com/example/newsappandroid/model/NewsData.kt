package com.example.newsappandroid.model

data class NewsData(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)

data class Article(
    val title: String,
)