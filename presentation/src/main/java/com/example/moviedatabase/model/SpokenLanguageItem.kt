package com.example.moviedatabase.model

import com.example.moviedatabase.base.ItemMapper
import com.example.moviedatabase.base.ModelItem
import com.example.moviedatabase.domain.model.SpokenLanguage
import javax.inject.Inject

data class SpokenLanguageItem(
    val iso6391: String? = null,
    val name: String? = null
) : ModelItem()

class SpokenLanguageItemMapper @Inject constructor() :
    ItemMapper<SpokenLanguage, SpokenLanguageItem> {

    override fun mapToDomain(modelItem: SpokenLanguageItem): SpokenLanguage {
        return SpokenLanguage(iso6391 = modelItem.iso6391, name = modelItem.name)
    }

    override fun mapToPresentation(model: SpokenLanguage): SpokenLanguageItem {
        return SpokenLanguageItem(iso6391 = model.iso6391, name = model.name)
    }
}
