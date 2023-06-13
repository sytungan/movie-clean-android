package com.example.moviedatabase.data.model

import com.example.moviedatabase.data.base.EntityMapper
import com.example.moviedatabase.data.base.ModelEntity
import com.example.moviedatabase.domain.model.ProductionCompany
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class ProductionCompanyEntity(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("logo_path")
    val logoPath: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("origin_country")
    val originCountry: String? = null
) : ModelEntity()

class ProductionCompanyEntityMapper @Inject constructor() :
    EntityMapper<ProductionCompany, ProductionCompanyEntity> {
    override fun mapToDomain(entity: ProductionCompanyEntity): ProductionCompany {
        return ProductionCompany(
            id = entity.id,
            logoPath = entity.logoPath,
            name = entity.name,
            originCountry = entity.originCountry
        )
    }

    override fun mapToEntity(model: ProductionCompany): ProductionCompanyEntity {
        return ProductionCompanyEntity(
            id = model.id,
            logoPath = model.logoPath,
            name = model.name,
            originCountry = model.originCountry
        )
    }
}
