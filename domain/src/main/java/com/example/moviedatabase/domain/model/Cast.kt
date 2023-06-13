package com.example.moviedatabase.domain.model

data class Cast(
    val castId: Int? = 0,
    val character: String? = "",
    val creditId: String? = "",
    val gender: Int? = 0,
    val id: Int? = 0,
    val name: String? = "",
    val order: Int? = 0,
    val profilePath: String? = ""
) : Model()
