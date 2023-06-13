package com.example.moviedatabase.model

import com.example.moviedatabase.base.ItemMapper
import com.example.moviedatabase.base.ModelItem
import com.example.moviedatabase.domain.model.ProductionCountry
import javax.inject.Inject

data class ProductionCountryItem(
    val iso31661: String? = null,
    val name: String? = null
) : ModelItem()

class ProductionCountryItemMapper @Inject constructor() :
    ItemMapper<ProductionCountry, ProductionCountryItem> {
    override fun mapToDomain(modelItem: ProductionCountryItem): ProductionCountry {
        return ProductionCountry(iso31661 = modelItem.iso31661, name = modelItem.name)
    }

    override fun mapToPresentation(model: ProductionCountry): ProductionCountryItem {
        return ProductionCountryItem(iso31661 = model.iso31661, name = model.name)
    }
}
