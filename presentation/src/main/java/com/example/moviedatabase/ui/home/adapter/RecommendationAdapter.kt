package com.example.moviedatabase.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.moviedatabase.R
import com.example.moviedatabase.base.BaseRecyclerAdapter
import com.example.moviedatabase.databinding.ItemRecommendationBinding
import com.example.moviedatabase.model.MovieItem

class RecommendationAdapter(val onClickMovieListener: ((MovieItem) -> Unit)?) :
    BaseRecyclerAdapter<MovieItem>(

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
        return DataBindingUtil.inflate<ItemRecommendationBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_recommendation, parent, false
        ).apply {
            root.setOnClickListener {
                item?.let { item ->
                    onClickMovieListener?.invoke(item)
                }
            }
        }
    }

    override fun bind(binding: ViewDataBinding, movieItem: MovieItem) {
        if (binding is ItemRecommendationBinding) {
            binding.apply {
                item = movieItem
            }
        }
    }
}
