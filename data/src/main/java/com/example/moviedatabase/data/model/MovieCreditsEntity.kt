package com.example.moviedatabase.data.model

import com.example.moviedatabase.data.base.EntityMapper
import com.example.moviedatabase.data.base.ModelEntity
import com.example.moviedatabase.domain.model.MovieCredits
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class MovieCreditsEntity(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("cast")
    val cast: List<CastEntity>? = listOf(),
    @SerializedName("crew")
    val crew: List<CrewEntity>? = listOf()
) : ModelEntity()

class MovieCreditsEntityMapper @Inject constructor(
    private val castEntityMapper: CastEntityMapper,
    private val crewEntityMapper: CrewEntityMapper
) : EntityMapper<MovieCredits, MovieCreditsEntity> {
    override fun mapToDomain(entity: MovieCreditsEntity): MovieCredits {
        return MovieCredits(
            id = entity.id,
            cast = entity.cast?.map { castEntityMapper.mapToDomain(it) },
            crew = entity.crew?.map { crewEntityMapper.mapToDomain(it) }
        )
    }

    override fun mapToEntity(model: MovieCredits): MovieCreditsEntity {
        return MovieCreditsEntity(
            id = model.id,
            cast = model.cast?.map { castEntityMapper.mapToEntity(it) },
            crew = model.crew?.map { crewEntityMapper.mapToEntity(it) }
        )
    }

}
