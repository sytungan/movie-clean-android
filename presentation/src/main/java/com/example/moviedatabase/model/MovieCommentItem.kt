package com.example.moviedatabase.model

import com.example.moviedatabase.base.ItemMapper
import com.example.moviedatabase.base.ModelItem
import com.example.moviedatabase.domain.model.MovieComment
import javax.inject.Inject

data class MovieCommentItem(
    val id: String? = "",
    val author: String? = "",
    val content: String? = "",
    val url: String? = ""
) : ModelItem()

class MovieCommentItemMapper @Inject constructor() :
    ItemMapper<MovieComment, MovieCommentItem> {
    override fun mapToDomain(modelItem: MovieCommentItem): MovieComment {
        return MovieComment(
            id = modelItem.id,
            author = modelItem.author,
            content = modelItem.content,
            url = modelItem.url
        )
    }

    override fun mapToPresentation(model: MovieComment): MovieCommentItem {
        return MovieCommentItem(
            id = model.id,
            author = model.author,
            content = model.content,
            url = model.url
        )
    }

}