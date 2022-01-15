package com.example.newsappandroid.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsappandroid.R
import com.example.newsappandroid.model.Article

class ArticleAdapter(
    private var articles: List<Article>
): RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_article, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    override fun getItemCount(): Int {
        return  articles.size
    }

    fun update(data: List<Article>) {
        articles = data
        notifyDataSetChanged()
    }

    class ArticleViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.title)
        private val articleImageView: ImageView = view.findViewById(R.id.articleImageView)
        fun bind(article: Article) {
            title.text = article.title
            Glide.with(articleImageView.context).load(article.urlToImage).into(articleImageView)
        }
    }
}