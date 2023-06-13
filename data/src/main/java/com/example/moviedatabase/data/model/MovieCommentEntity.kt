package com.example.moviedatabase.data.model

import com.example.moviedatabase.data.base.EntityMapper
import com.example.moviedatabase.data.base.ModelEntity
import com.example.moviedatabase.domain.model.MovieComment
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class MovieCommentEntity(
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("author")
    val author: String? = "",
    @SerializedName("content")
    val content: String? = "",
    @SerializedName("url")
    val url: String? = ""
) : ModelEntity()

class MovieCommentEntityMapper @Inject constructor() :
    EntityMapper<MovieComment, MovieCommentEntity> {
    override fun mapToDomain(entity: MovieCommentEntity): MovieComment {
        return MovieComment(
            id = entity.id,
            author = entity.author,
            content = entity.content,
            url = entity.url
        )
    }

    override fun mapToEntity(model: MovieComment): MovieCommentEntity {
        return MovieCommentEntity(
            id = model.id,
            author = model.author,
            content = model.content,
            url = model.url
        )
    }

}