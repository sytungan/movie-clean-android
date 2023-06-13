package com.example.moviedatabase.data.model

import com.example.moviedatabase.data.base.EntityMapper
import com.example.moviedatabase.data.base.ModelEntity
import com.example.moviedatabase.domain.model.MovieVideos
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class MovieVideosEntity(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("results")
    val results: List<MovieVideoResultEntity>? = listOf()
) : ModelEntity()

class MovieVideosEntityMapper @Inject constructor(
    private val moveVideoResultEntityMapper: MovieVideoResultEntityMapper
) : EntityMapper<MovieVideos, MovieVideosEntity> {
    override fun mapToDomain(entity: MovieVideosEntity): MovieVideos {
        return MovieVideos(id = entity.id, results = entity.results?.map {
            moveVideoResultEntityMapper.mapToDomain(it)
        })
    }

    override fun mapToEntity(model: MovieVideos): MovieVideosEntity {
        return MovieVideosEntity(id = model.id, results = model.results?.map {
            moveVideoResultEntityMapper.mapToEntity(it)
        })
    }
}
