package com.example.moviedatabase.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.moviedatabase.R
import com.example.moviedatabase.base.BaseRecyclerAdapter
import com.example.moviedatabase.databinding.ItemGenreBinding
import com.example.moviedatabase.model.GenreItem

class CategoryAdapter(val onClickMovieListener: ((GenreItem) -> Unit)?) :
    BaseRecyclerAdapter<GenreItem>(

        callBack = object : DiffUtil.ItemCallback<GenreItem>() {
            override fun areItemsTheSame(oldItem: GenreItem, newItem: GenreItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: GenreItem,
                newItem: GenreItem
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }) {

    override fun createBinding(parent: ViewGroup, viewType: Int?): ViewDataBinding {
        return DataBindingUtil.inflate<ItemGenreBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_genre, parent, false
        ).apply {
            root.setOnClickListener {
                item?.let {
                    onClickMovieListener?.invoke(it)
                }
            }
        }
    }

    override fun bind(binding: ViewDataBinding, genreItem: GenreItem) {
        if (binding is ItemGenreBinding) {
            binding.apply {
                item = genreItem
                imageViewBackground.setBackgroundResource(
                    when ((0..2).random()) {
                        0 -> {
                            R.drawable.ic_background_category
                        }
                        1 -> {
                            R.drawable.ic_background_category_2
                        }
                        else -> {
                            R.drawable.ic_background_category_3
                        }
                    }
                )
            }
        }
    }
}
