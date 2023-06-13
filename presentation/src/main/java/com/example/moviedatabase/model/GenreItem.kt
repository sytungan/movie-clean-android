package com.example.moviedatabase.model

import com.example.moviedatabase.base.ItemMapper
import com.example.moviedatabase.base.ModelItem
import com.example.moviedatabase.domain.model.Genre
import javax.inject.Inject

data class GenreItem(
    val id: Int? = 0,
    val name: String? = ""
) : ModelItem()

class GenreItemMapper @Inject constructor() : ItemMapper<Genre, GenreItem> {
    override fun mapToPresentation(model: Genre): GenreItem = GenreItem(
        id = model.id,
        name = model.name
    )

    override fun mapToDomain(modelItem: GenreItem) = Genre(
        id = modelItem.id,
        name = modelItem.name
    )
}
