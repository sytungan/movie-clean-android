package com.example.moviedatabase.domain.model

data class MovieVideoResult(
    val id: String? = "",
    val iso31661: String? = "",
    val iso6391: String? = "",
    val key: String? = "",
    val name: String? = "",
    val site: String? = "",
    val size: Int? = 0,
    val type: String? = ""
) : Model()
