package com.example.moviedatabase.data.model


import com.example.moviedatabase.data.base.EntityMapper
import com.example.moviedatabase.data.base.ModelEntity
import com.example.moviedatabase.domain.model.MovieVideoResult
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class MovieVideoResultEntity(
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("iso_3166_1")
    val iso31661: String? = "",
    @SerializedName("iso_639_1")
    val iso6391: String? = "",
    @SerializedName("key")
    val key: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("site")
    val site: String? = "",
    @SerializedName("size")
    val size: Int? = 0,
    @SerializedName("type")
    val type: String? = ""
) : ModelEntity()

class MovieVideoResultEntityMapper @Inject constructor() :
    EntityMapper<MovieVideoResult, MovieVideoResultEntity> {
    override fun mapToDomain(entity: MovieVideoResultEntity): MovieVideoResult {
        return MovieVideoResult(
            id = entity.id,
            iso31661 = entity.iso31661,
            iso6391 = entity.iso6391,
            key = entity.key,
            name = entity.name,
            site = entity.site,
            size = entity.size,
            type = entity.type
        )
    }

    override fun mapToEntity(model: MovieVideoResult): MovieVideoResultEntity {
        return MovieVideoResultEntity(
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
