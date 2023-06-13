package com.example.moviedatabase.data.model

import com.example.moviedatabase.data.base.EntityMapper
import com.example.moviedatabase.data.base.ModelEntity
import com.example.moviedatabase.domain.model.MovieDetail
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class MovieDetailEntity(
    @SerializedName("adult")
    val adult: Boolean? = null,
    @SerializedName("backdrop_path")
    val backdropPath: String? = null,
    @SerializedName("belongs_to_collection")
    val belongsToCollection: Any? = null,
    @SerializedName("budget")
    val budget: Int? = null,
    @SerializedName("genres")
    val genres: List<GenreEntity>? = null,
    @SerializedName("homepage")
    val homepage: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("imdb_id")
    val imdbId: String? = null,
    @SerializedName("original_language")
    val originalLanguage: String? = null,
    @SerializedName("original_title")
    val originalTitle: String? = null,
    @SerializedName("overview")
    val overview: String? = null,
    @SerializedName("popularity")
    val popularity: Double? = null,
    @SerializedName("poster_path")
    val posterPath: String? = null,
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompanyEntity>? = null,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountryEntity>? = null,
    @SerializedName("release_date")
    val releaseDate: String? = null,
    @SerializedName("revenue")
    val revenue: Int? = null,
    @SerializedName("runtime")
    val runtime: Int? = null,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguageEntity>? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("tagline")
    val tagline: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("video")
    val video: Boolean? = null,
    @SerializedName("vote_average")
    val voteAverage: Double? = null,
    @SerializedName("vote_count")
    val voteCount: Int? = null
) : ModelEntity()

class MovieDetailEntityMapper @Inject constructor(
    private val genreEntityMapper: GenreEntityMapper,
    private val productionCompanyEntityMapper: ProductionCompanyEntityMapper,
    private val productionCountryEntityMapper: ProductionCountryEntityMapper,
    private val spokenLanguageEntityMapper: SpokenLanguageEntityMapper
) : EntityMapper<MovieDetail, MovieDetailEntity> {

    override fun mapToDomain(entity: MovieDetailEntity): MovieDetail {
        return MovieDetail(
            adult = entity.adult,
            backdropPath = entity.backdropPath,
            belongsToCollection = entity.belongsToCollection,
            budget = entity.budget,
            genres = entity.genres?.map { genreEntityMapper.mapToDomain(it) },
            homepage = entity.homepage,
            id = entity.id,
            imdbId = entity.imdbId,
            originalLanguage = entity.originalLanguage,
            originalTitle = entity.originalTitle,
            overview = entity.overview,
            popularity = entity.popularity,
            posterPath = entity.posterPath,
            productionCompanies = entity.productionCompanies?.map {
                productionCompanyEntityMapper.mapToDomain(it)
            },
            productionCountries = entity.productionCountries?.map {
                productionCountryEntityMapper.mapToDomain(it)
            },
            releaseDate = entity.releaseDate,
            revenue = entity.revenue,
            runtime = entity.runtime,
            spokenLanguages = entity.spokenLanguages?.map {
                spokenLanguageEntityMapper.mapToDomain(it)
            },
            status = entity.status,
            tagline = entity.tagline,
            title = entity.title,
            video = entity.video,
            voteAverage = entity.voteAverage,
            voteCount = entity.voteCount
        )
    }

    override fun mapToEntity(model: MovieDetail): MovieDetailEntity {
        return MovieDetailEntity(
            adult = model.adult,
            backdropPath = model.backdropPath,
            belongsToCollection = model.belongsToCollection,
            budget = model.budget,
            genres = model.genres?.map { genreEntityMapper.mapToEntity(it) },
            homepage = model.homepage,
            id = model.id,
            imdbId = model.imdbId,
            originalLanguage = model.originalLanguage,
            originalTitle = model.originalTitle,
            overview = model.overview,
            popularity = model.popularity,
            posterPath = model.posterPath,
            productionCompanies = model.productionCompanies?.map {
                productionCompanyEntityMapper.mapToEntity(it)
            },
            productionCountries = model.productionCountries?.map {
                productionCountryEntityMapper.mapToEntity(it)
            },
            releaseDate = model.releaseDate,
            revenue = model.revenue,
            runtime = model.runtime,
            spokenLanguages = model.spokenLanguages?.map {
                spokenLanguageEntityMapper.mapToEntity(it)
            },
            status = model.status,
            tagline = model.tagline,
            title = model.title,
            video = model.video,
            voteAverage = model.voteAverage,
            voteCount = model.voteCount
        )
    }

}
