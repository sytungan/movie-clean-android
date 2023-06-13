package com.example.moviedatabase.ui.moviedetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.moviedatabase.R
import com.example.moviedatabase.base.BaseRecyclerAdapter
import com.example.moviedatabase.databinding.ItemMovieDetailCommentBinding
import com.example.moviedatabase.model.MovieCommentItem

class MovieCommentAdapter : BaseRecyclerAdapter<MovieCommentItem>(DIFF_CALLBACK) {

    override fun createBinding(parent: ViewGroup, viewType: Int?): ViewDataBinding {
        return DataBindingUtil.inflate<ItemMovieDetailCommentBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_movie_detail_comment,
            parent,
            false
        )
    }

    override fun bind(binding: ViewDataBinding, item: MovieCommentItem) {
        if (binding is ItemMovieDetailCommentBinding) {
            binding.item = item
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieCommentItem>() {
            override fun areItemsTheSame(
                oldItem: MovieCommentItem,
                newItem: MovieCommentItem
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: MovieCommentItem,
                newItem: MovieCommentItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
