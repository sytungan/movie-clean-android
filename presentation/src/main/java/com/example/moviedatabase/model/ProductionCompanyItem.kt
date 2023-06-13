package com.example.moviedatabase.model

import com.example.moviedatabase.base.ItemMapper
import com.example.moviedatabase.base.ModelItem
import com.example.moviedatabase.domain.model.ProductionCompany
import javax.inject.Inject

data class ProductionCompanyItem(
    val id: Int? = null,
    val logoPath: String? = null,
    val name: String? = null,
    val originCountry: String? = null
) : ModelItem()

class ProductionCompanyItemMapper @Inject constructor() :
    ItemMapper<ProductionCompany, ProductionCompanyItem> {
    override fun mapToDomain(modelItem: ProductionCompanyItem): ProductionCompany {
        return ProductionCompany(
            id = modelItem.id,
            logoPath = modelItem.logoPath,
            name = modelItem.name,
            originCountry = modelItem.originCountry
        )
    }

    override fun mapToPresentation(model: ProductionCompany): ProductionCompanyItem {
        return ProductionCompanyItem(
            id = model.id,
            logoPath = model.logoPath,
            name = model.name,
            originCountry = model.originCountry
        )
    }

}
