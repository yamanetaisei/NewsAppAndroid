package com.example.newsappandroid.repository

import com.example.newsappandroid.data.ApiClient.retrofit
import com.example.newsappandroid.data.HeadlinesApiRequest
import com.example.newsappandroid.model.NewsData
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ArticleListRepository {
    val key = "30d06e4f9a934402a204fa89f9d9acfc"
    fun fetchArticles(country: String, category: String): Single<NewsData> {
        return retrofit.create(HeadlinesApiRequest::class.java).fetch(country, category, key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                it.body()
            }
    }
}