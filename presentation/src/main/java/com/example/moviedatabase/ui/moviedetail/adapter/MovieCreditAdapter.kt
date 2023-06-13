package com.example.moviedatabase.ui.moviedetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.moviedatabase.R
import com.example.moviedatabase.base.BaseRecyclerAdapter
import com.example.moviedatabase.databinding.ItemMovieDetailSeriesCastBinding
import com.example.moviedatabase.model.CastItem

class MovieCreditAdapter : BaseRecyclerAdapter<CastItem>(DIFF_CALLBACK) {

    override fun createBinding(parent: ViewGroup, viewType: Int?): ViewDataBinding {
        return DataBindingUtil.inflate<ItemMovieDetailSeriesCastBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_movie_detail_series_cast,
            parent,
            false
        )
    }

    override fun bind(binding: ViewDataBinding, item: CastItem) {
        if (binding is ItemMovieDetailSeriesCastBinding) {
            binding.item = item
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CastItem>() {
            override fun areItemsTheSame(oldItem: CastItem, newItem: CastItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CastItem, newItem: CastItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}
