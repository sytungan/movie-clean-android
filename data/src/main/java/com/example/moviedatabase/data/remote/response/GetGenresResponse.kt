package com.example.moviedatabase.data.remote.response

import com.example.moviedatabase.data.model.GenreEntity
import com.google.gson.annotations.SerializedName
import java.util.*

class GetGenresResponse(
    @SerializedName("genres")
    val genres: ArrayList<GenreEntity>? = ArrayList()
)
