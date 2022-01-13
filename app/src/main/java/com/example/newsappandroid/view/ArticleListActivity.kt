package com.example.newsappandroid.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsappandroid.R
import com.example.newsappandroid.model.MockArticle
import com.example.newsappandroid.viewmodel.ArticleListViewModel

class ArticleListActivity : AppCompatActivity() {

    private val mockArticle = MockArticle()
    private var viewModel = ArticleListViewModel()
    private lateinit var adapter: ArticleAdapter
    private lateinit var  recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_list)

        setupUI()
    }

    private fun setupUI() {
        recyclerView = findViewById(R.id.recyclerView)
        adapter = ArticleAdapter(viewModel.articles.value ?: emptyList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}