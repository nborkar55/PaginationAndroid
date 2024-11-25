package com.example.imagesearchapp.presentation.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imagesearchapp.data.model.TopNewsResponse
import com.example.imagesearchapp.databinding.ItemNewsBinding

class NewsAdapter(val newsList: List<TopNewsResponse.TopNews.News>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(news: TopNewsResponse.TopNews.News) {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = newsList.size
}
