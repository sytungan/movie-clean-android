package com.example.moviedatabase.model

import com.example.moviedatabase.BuildConfig
import com.example.moviedatabase.base.ItemMapper
import com.example.moviedatabase.base.ModelItem
import com.example.moviedatabase.domain.model.Cast
import javax.inject.Inject

data class CastItem(
    val castId: Int? = 0,
    val character: String? = "",
    val creditId: String? = "",
    val gender: Int? = 0,
    val id: Int? = 0,
    val name: String? = "",
    val order: Int? = 0,
    val profilePath: String? = ""
) : ModelItem()

class CastItemMapper @Inject constructor() : ItemMapper<Cast, CastItem> {
    override fun mapToDomain(modelItem: CastItem): Cast {
        return Cast(
            id = modelItem.id,
            castId = modelItem.castId,
            character = modelItem.character,
            creditId = modelItem.creditId,
            gender = modelItem.gender,
            name = modelItem.name,
            order = modelItem.order,
            profilePath = modelItem.profilePath
        )
    }

    override fun mapToPresentation(model: Cast): CastItem {
        return CastItem(
            id = model.id,
            castId = model.castId,
            character = model.character,
            creditId = model.creditId,
            gender = model.gender,
            name = model.name,
            order = model.order,
            profilePath = BuildConfig.URL_IMAGE + (model.profilePath ?: "")
        )
    }
}

