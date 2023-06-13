package com.example.moviedatabase.domain.model

data class MovieVideos(
    val id: Int? = 0,
    val results: List<MovieVideoResult>? = listOf()
) : Model()
