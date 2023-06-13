package com.example.moviedatabase.data.model

import com.example.moviedatabase.data.base.EntityMapper
import com.example.moviedatabase.data.base.ModelEntity
import com.example.moviedatabase.domain.model.Genre
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

class GenreEntity(
    @SerializedName("id") val id: Int? = 0,
    @SerializedName("name") val name: String? = ""
) : ModelEntity()

class GenreEntityMapper @Inject constructor() : EntityMapper<Genre, GenreEntity> {
    override fun mapToDomain(entity: GenreEntity) = Genre(
        id = entity.id,
        name = entity.name
    )

    override fun mapToEntity(model: Genre) = GenreEntity(
        id = model.id,
        name = model.name
    )
}
