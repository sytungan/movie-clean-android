package com.example.moviedatabase.data.remote.response

import com.example.moviedatabase.data.model.MovieCommentEntity
import com.google.gson.annotations.SerializedName

data class GetMovieCommentsResponse(
    @SerializedName("id")
    val id: Int? = 0
) : BaseListMovieResponse<MovieCommentEntity>()
