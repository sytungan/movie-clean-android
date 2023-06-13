package com.example.moviedatabase.model

import com.example.moviedatabase.BuildConfig
import com.example.moviedatabase.base.ItemMapper
import com.example.moviedatabase.base.ModelItem
import com.example.moviedatabase.domain.model.Crew
import javax.inject.Inject

data class CrewItem(
    val creditId: String? = "",
    val department: String? = "",
    val gender: Int? = 0,
    val id: Int? = 0,
    val job: String? = "",
    val name: String? = "",
    val profilePath: String? = ""
) : ModelItem()

class CrewItemMapper @Inject constructor() : ItemMapper<Crew, CrewItem> {
    override fun mapToDomain(modelItem: CrewItem): Crew {
        return Crew(
            id = modelItem.id,
            creditId = modelItem.creditId,
            department = modelItem.department,
            gender = modelItem.gender,
            job = modelItem.job,
            name = modelItem.name,
            profilePath = modelItem.profilePath
        )
    }

    override fun mapToPresentation(model: Crew): CrewItem {
        return CrewItem(
            id = model.id,
            creditId = model.creditId,
            department = model.department,
            gender = model.gender,
            job = model.job,
            name = model.name,
            profilePath = BuildConfig.URL_IMAGE + (model.profilePath ?: "")
        )
    }
}

