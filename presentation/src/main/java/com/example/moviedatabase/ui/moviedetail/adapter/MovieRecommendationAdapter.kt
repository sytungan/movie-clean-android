package com.example.moviedatabase.ui.moviedetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.moviedatabase.R
import com.example.moviedatabase.base.BaseRecyclerAdapter
import com.example.moviedatabase.databinding.ItemMovieDetailRecommendationsBinding
import com.example.moviedatabase.model.MovieItem

class MovieRecommendationAdapter : BaseRecyclerAdapter<MovieItem>(
    callBack = object : DiffUtil.ItemCallback<MovieItem>() {
        override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: MovieItem,
            newItem: MovieItem
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }) {

    override fun createBinding(parent: ViewGroup, viewType: Int?): ViewDataBinding {
        return DataBindingUtil.inflate<ItemMovieDetailRecommendationsBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_movie_detail_recommendations, parent, false
        )
    }

    override fun bind(binding: ViewDataBinding, movieItem: MovieItem) {
        if (binding is ItemMovieDetailRecommendationsBinding) {
            binding.item = movieItem
        }
    }
}
