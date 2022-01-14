package com.example.newsappandroid.data

import com.example.newsappandroid.model.NewsData
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HeadlinesApiRequest {
    @GET("/v2/top-headlines")
    fun fetch(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): Single<Response<NewsData>>
}