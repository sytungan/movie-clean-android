package com.example.moviedatabase.data.model

import com.example.moviedatabase.data.base.EntityMapper
import com.example.moviedatabase.data.base.ModelEntity
import com.example.moviedatabase.domain.model.Cast
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class CastEntity(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("cast_id")
    val castId: Int? = 0,
    @SerializedName("character")
    val character: String? = "",
    @SerializedName("credit_id")
    val creditId: String? = "",
    @SerializedName("gender")
    val gender: Int? = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("order")
    val order: Int? = 0,
    @SerializedName("profile_path")
    val profilePath: String? = ""
) : ModelEntity()

class CastEntityMapper @Inject constructor() : EntityMapper<Cast, CastEntity> {
    override fun mapToDomain(entity: CastEntity): Cast {
        return Cast(
            id = entity.id,
            castId = entity.castId,
            character = entity.character,
            creditId = entity.creditId,
            gender = entity.gender,
            name = entity.name,
            order = entity.order,
            profilePath = entity.profilePath
        )
    }

    override fun mapToEntity(model: Cast): CastEntity {
        return CastEntity(
            id = model.id,
            castId = model.castId,
            character = model.character,
            creditId = model.creditId,
            gender = model.gender,
            name = model.name,
            order = model.order,
            profilePath = model.profilePath
        )
    }
}
