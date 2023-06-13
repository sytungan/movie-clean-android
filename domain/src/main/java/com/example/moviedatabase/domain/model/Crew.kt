package com.example.moviedatabase.domain.model

data class Crew(
    val creditId: String? = "",
    val department: String? = "",
    val gender: Int? = 0,
    val id: Int? = 0,
    val job: String? = "",
    val name: String? = "",
    val profilePath: String? = ""
) : Model()
