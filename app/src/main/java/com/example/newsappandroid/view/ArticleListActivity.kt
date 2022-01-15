package com.example.newsappandroid.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsappandroid.R
import com.example.newsappandroid.model.Article
import com.example.newsappandroid.viewmodel.ArticleListViewModel
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration

class ArticleListActivity : AppCompatActivity() {

    private val viewModel by viewModels<ArticleListViewModel>()
    private lateinit var adapter: ArticleAdapter
    private lateinit var  recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_list)

        setupUI()
        setupViewModel()
    }

    private fun setupUI() {
        recyclerView = findViewById(R.id.recyclerView)
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecoration)
        adapter = ArticleAdapter(viewModel.articles.value ?: emptyList())
        rowClick()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun setupViewModel() {
        viewModel.articles.observe(this, renderArticles)
    }

    private fun rowClick() {
        adapter.setOnArticleRowClickListener(
            object : ArticleAdapter.OnArticleRowClickListener {
                override fun onClick(article: Article) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(article.url))
                    startActivity(intent)
                }
            }
        )
    }

    private val renderArticles = Observer<List<Article>> { articles ->
        println(articles)
        adapter.update(articles)
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetch("jp", "general")
    }
}