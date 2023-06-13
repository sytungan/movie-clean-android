package com.example.moviedatabase.data.model

import com.example.moviedatabase.data.base.EntityMapper
import com.example.moviedatabase.data.base.ModelEntity
import com.example.moviedatabase.domain.model.SpokenLanguage
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class SpokenLanguageEntity(
    @SerializedName("iso_639_1")
    val iso6391: String? = null,
    @SerializedName("name")
    val name: String? = null
) : ModelEntity()

class SpokenLanguageEntityMapper @Inject constructor() :
    EntityMapper<SpokenLanguage, SpokenLanguageEntity> {
    override fun mapToDomain(entity: SpokenLanguageEntity): SpokenLanguage {
        return SpokenLanguage(iso6391 = entity.iso6391, name = entity.name)
    }

    override fun mapToEntity(model: SpokenLanguage): SpokenLanguageEntity {
        return SpokenLanguageEntity(iso6391 = model.iso6391, name = model.name)
    }
}
