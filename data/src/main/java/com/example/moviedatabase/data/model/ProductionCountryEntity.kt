package com.example.moviedatabase.data.model

import com.example.moviedatabase.data.base.EntityMapper
import com.example.moviedatabase.data.base.ModelEntity
import com.example.moviedatabase.domain.model.ProductionCountry
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class ProductionCountryEntity(
    @SerializedName("iso_3166_1")
    val iso31661: String? = null,
    @SerializedName("name")
    val name: String? = null
) : ModelEntity()

class ProductionCountryEntityMapper @Inject constructor() :
    EntityMapper<ProductionCountry, ProductionCountryEntity> {
    override fun mapToDomain(entity: ProductionCountryEntity): ProductionCountry {
        return ProductionCountry(iso31661 = entity.iso31661, name = entity.name)
    }

    override fun mapToEntity(model: ProductionCountry): ProductionCountryEntity {
        return ProductionCountryEntity(iso31661 = model.iso31661, name = model.name)
    }
}
