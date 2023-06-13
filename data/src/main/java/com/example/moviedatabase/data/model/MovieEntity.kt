package com.example.moviedatabase.data.model

import com.example.moviedatabase.data.base.EntityMapper
import com.example.moviedatabase.data.base.ModelEntity
import com.example.moviedatabase.domain.model.Movie
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class MovieEntity(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("adult")
    val adult: Boolean? = false,
    @SerializedName("backdrop_path")
    val backdropPath: String? = "",
    @SerializedName("original_language")
    val originalLanguage: String? = "",
    @SerializedName("original_title")
    val originalTitle: String? = "",
    @SerializedName("overview")
    val overview: String? = "",
    @SerializedName("popularity")
    val popularity: Double? = 0.0,
    @SerializedName("poster_path")
    val posterPath: String? = "",
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("video")
    val video: Boolean? = false,
    @SerializedName("vote_average")
    val voteAverage: Double? = 0.0,
    @SerializedName("vote_count")
    val voteCount: Int? = 0
) : ModelEntity()


class MovieEntityMapper @Inject constructor() : EntityMapper<Movie, MovieEntity> {
    override fun mapToDomain(entity: MovieEntity) = Movie(
        id = entity.id,
        adult = entity.adult,
        backdropPath = entity.backdropPath,
        originalLanguage = entity.originalLanguage,
        originalTitle = entity.originalTitle,
        overview = entity.overview,
        popularity = entity.popularity,
        posterPath = entity.posterPath,
        title = entity.title,
        video = entity.video,
        voteAverage = entity.voteAverage,
        voteCount = entity.voteCount
    )

    override fun mapToEntity(model: Movie) = MovieEntity(
        id = model.id,
        adult = model.adult,
        backdropPath = model.backdropPath,
        originalLanguage = model.originalLanguage,
        originalTitle = model.originalTitle,
        overview = model.overview,
        popularity = model.popularity,
        posterPath = model.posterPath,
        title = model.title,
        video = model.video,
        voteAverage = model.voteAverage,
        voteCount = model.voteCount
    )
}
