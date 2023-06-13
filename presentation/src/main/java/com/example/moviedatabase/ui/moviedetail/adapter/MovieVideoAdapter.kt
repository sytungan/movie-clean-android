package com.example.moviedatabase.ui.moviedetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.moviedatabase.R
import com.example.moviedatabase.base.BaseRecyclerAdapter
import com.example.moviedatabase.databinding.ItemMovieDetailVideoBinding
import com.example.moviedatabase.model.MovieVideoResultItem

class MovieVideoAdapter : BaseRecyclerAdapter<MovieVideoResultItem>(DIFF_CALLBACK) {

    override fun createBinding(parent: ViewGroup, viewType: Int?): ViewDataBinding {
        return DataBindingUtil.inflate<ItemMovieDetailVideoBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_movie_detail_video,
            parent,
            false
        )
    }

    override fun bind(binding: ViewDataBinding, item: MovieVideoResultItem) {
        if (binding is ItemMovieDetailVideoBinding) {
            binding.item = item
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieVideoResultItem>() {
            override fun areItemsTheSame(
                oldItem: MovieVideoResultItem,
                newItem: MovieVideoResultItem
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: MovieVideoResultItem,
                newItem: MovieVideoResultItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
