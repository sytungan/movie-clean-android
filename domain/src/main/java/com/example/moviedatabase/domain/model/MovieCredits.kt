package com.example.moviedatabase.domain.model

data class MovieCredits(
    val cast: List<Cast>? = listOf(),
    val crew: List<Crew>? = listOf(),
    val id: Int? = 0
) : Model()
