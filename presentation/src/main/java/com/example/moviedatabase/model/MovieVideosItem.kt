package com.example.moviedatabase.model

import com.example.moviedatabase.base.ItemMapper
import com.example.moviedatabase.base.ModelItem
import com.example.moviedatabase.domain.model.MovieVideos
import javax.inject.Inject

data class MovieVideosItem(
    val id: Int? = 0,
    val results: List<MovieVideoResultItem>? = listOf()
) : ModelItem()

class MovieVideosItemMapper @Inject constructor(
    private val moveVideoResultItemMapper: MovieVideoResultItemMapper
) : ItemMapper<MovieVideos, MovieVideosItem> {
    override fun mapToDomain(modelItem: MovieVideosItem): MovieVideos {
        return MovieVideos(id = modelItem.id, results = modelItem.results?.map {
            moveVideoResultItemMapper.mapToDomain(it)
        })
    }

    override fun mapToPresentation(model: MovieVideos): MovieVideosItem {
        return MovieVideosItem(id = model.id, results = model.results?.map {
            moveVideoResultItemMapper.mapToPresentation(it)
        })
    }

}

