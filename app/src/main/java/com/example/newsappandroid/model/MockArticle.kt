package com.example.newsappandroid.model

data class MockArticle(
    val articlesMock: List<Article> = listOf<Article>(
        Article(title = "hoge"),
        Article(title = "fuga"),
    )
)
