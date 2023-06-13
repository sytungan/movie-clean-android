package com.example.moviedatabase.model

import com.example.moviedatabase.base.ItemMapper
import com.example.moviedatabase.base.ModelItem
import com.example.moviedatabase.domain.model.MovieVideoResult
import javax.inject.Inject

data class MovieVideoResultItem(
    val id: String? = "",
    val iso31661: String? = "",
    val iso6391: String? = "",
    val key: String? = "",
    val name: String? = "",
    val site: String? = "",
    val size: Int? = 0,
    val type: String? = ""
) : ModelItem() {
    fun getYoutubeThumbnail(): String {
        return "https://img.youtube.com/vi/$key/sddefault.jpg"
    }
}

class MovieVideoResultItemMapper @Inject constructor() :
    ItemMapper<MovieVideoResult, MovieVideoResultItem> {
    override fun mapToDomain(modelItem: MovieVideoResultItem): MovieVideoResult {
        return MovieVideoResult(
            id = modelItem.id,
            iso31661 = modelItem.iso31661,
            iso6391 = modelItem.iso6391,
            key = modelItem.key,
            name = modelItem.name,
            site = modelItem.site,
            size = modelItem.size,
            type = modelItem.type
        )
    }

    override fun mapToPresentation(model: MovieVideoResult): MovieVideoResultItem {
        return MovieVideoResultItem(
            id = model.id,
            iso31661 = model.iso31661,
            iso6391 = model.iso6391,
            key = model.key,
            name = model.name,
            site = model.site,
            size = model.size,
            type = model.type
        )
    }
}
