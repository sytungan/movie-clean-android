package com.example.moviedatabase.domain.model

data class Movie(
    val id: Int? = 0,
    val adult: Boolean? = false,
    val backdropPath: String? = "",
    val originalLanguage: String? = "",
    val originalTitle: String? = "",
    val overview: String? = "",
    val popularity: Double? = 0.0,
    val posterPath: String? = "",
    val title: String? = "",
    val video: Boolean? = false,
    val voteAverage: Double? = 0.0,
    val voteCount: Int? = 0
) : Model()
