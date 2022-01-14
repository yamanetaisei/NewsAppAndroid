package com.example.newsappandroid.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsappandroid.model.Article
import com.example.newsappandroid.repository.ArticleListRepository

class ArticleListViewModel: ViewModel() {
    private val repository = ArticleListRepository()
    private val _articles = MutableLiveData<List<Article>>().apply { value = emptyList() }
    val articles: LiveData<List<Article>> = _articles

    @SuppressLint("CheckResult")
    fun fetch(country: String, category: String) {
        repository.fetchArticles(country, category)
            .subscribe { data ->
                _articles.postValue(data.articles)
            }
    }
}