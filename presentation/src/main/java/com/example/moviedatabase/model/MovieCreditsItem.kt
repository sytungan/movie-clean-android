package com.example.moviedatabase.model

import com.example.moviedatabase.base.ItemMapper
import com.example.moviedatabase.base.ModelItem
import com.example.moviedatabase.domain.model.MovieCredits
import javax.inject.Inject

data class MovieCreditsItem(
    val castItem: List<CastItem>? = listOf(),
    val crewItem: List<CrewItem>? = listOf(),
    val id: Int? = 0
) : ModelItem()

class MovieCreditsItemMapper @Inject constructor(
    private val castItemMapper: CastItemMapper,
    private val crewItemMapper: CrewItemMapper
) : ItemMapper<MovieCredits, MovieCreditsItem> {
    override fun mapToDomain(modelItem: MovieCreditsItem): MovieCredits {
        return MovieCredits(
            id = modelItem.id,
            cast = modelItem.castItem?.map { castItemMapper.mapToDomain(it) },
            crew = modelItem.crewItem?.map { crewItemMapper.mapToDomain(it) }
        )
    }

    override fun mapToPresentation(model: MovieCredits): MovieCreditsItem {
        return MovieCreditsItem(
            id = model.id,
            castItem = model.cast?.map { castItemMapper.mapToPresentation(it) },
            crewItem = model.crew?.map { crewItemMapper.mapToPresentation(it) }
        )
    }

}
