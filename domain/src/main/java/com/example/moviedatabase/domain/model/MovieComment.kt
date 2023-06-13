package com.example.moviedatabase.domain.model

data class MovieComment(
    val id: String? = "",
    val author: String? = "",
    val content: String? = "",
    val url: String? = ""
) : Model()
