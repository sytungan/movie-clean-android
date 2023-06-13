package com.example.moviedatabase.model

import com.example.moviedatabase.BuildConfig
import com.example.moviedatabase.base.ItemMapper
import com.example.moviedatabase.base.ModelItem
import com.example.moviedatabase.domain.model.MovieDetail
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

data class MovieDetailItem(
    val adult: Boolean? = null,
    val backdropPath: String? = null,
    val belongsToCollection: Any? = null,
    val budget: Int? = null,
    val genres: List<GenreItem>? = null,
    val homepage: String? = null,
    val id: Int? = null,
    val imdbId: String? = null,
    val originalLanguage: String? = null,
    val originalTitle: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    val posterPath: String? = null,
    val productionCompanies: List<ProductionCompanyItem>? = null,
    val productionCountries: List<ProductionCountryItem>? = null,
    val releaseDate: Date? = null,
    val revenue: Int? = null,
    val runtime: Int? = null,
    val spokenLanguages: List<SpokenLanguageItem>? = null,
    val status: String? = null,
    val tagline: String? = null,
    val title: String? = null,
    val video: Boolean? = null,
    val voteAverage: Double? = null,
    val voteCount: Int? = null
) : ModelItem()

class MovieDetailItemMapper @Inject constructor(
    private val genreItemMapper: GenreItemMapper,
    private val productionCompanyItemMapper: ProductionCompanyItemMapper,
    private val productionCountryItemMapper: ProductionCountryItemMapper,
    private val spokenLanguageItemMapper: SpokenLanguageItemMapper
) : ItemMapper<MovieDetail, MovieDetailItem> {

    var simpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    override fun mapToDomain(modelItem: MovieDetailItem): MovieDetail {
        return MovieDetail(
            adult = modelItem.adult,
            backdropPath = modelItem.backdropPath,
            belongsToCollection = modelItem.belongsToCollection,
            budget = modelItem.budget,
            genres = modelItem.genres?.map { genreItemMapper.mapToDomain(it) },
            homepage = modelItem.homepage,
            id = modelItem.id,
            imdbId = modelItem.imdbId,
            originalLanguage = modelItem.originalLanguage,
            originalTitle = modelItem.originalTitle,
            overview = modelItem.overview,
            popularity = modelItem.popularity,
            posterPath = modelItem.posterPath,
            productionCompanies = modelItem.productionCompanies?.map {
                productionCompanyItemMapper.mapToDomain(it)
            },
            productionCountries = modelItem.productionCountries?.map {
                productionCountryItemMapper.mapToDomain(it)
            },
            releaseDate = if (modelItem.releaseDate != null) {
                simpleDateFormat.format(modelItem.releaseDate)
            } else {
                null
            },
            revenue = modelItem.revenue,
            runtime = modelItem.runtime,
            spokenLanguages = modelItem.spokenLanguages?.map {
                spokenLanguageItemMapper.mapToDomain(it)
            },
            status = modelItem.status,
            tagline = modelItem.tagline,
            title = modelItem.title,
            video = modelItem.video,
            voteAverage = modelItem.voteAverage,
            voteCount = modelItem.voteCount
        )
    }

    override fun mapToPresentation(model: MovieDetail): MovieDetailItem {
        return MovieDetailItem(
            adult = model.adult,
            backdropPath = BuildConfig.URL_IMAGE + (model.backdropPath ?: ""),
            belongsToCollection = model.belongsToCollection,
            budget = model.budget,
            genres = model.genres?.map { genreItemMapper.mapToPresentation(it) },
            homepage = model.homepage,
            id = model.id,
            imdbId = model.imdbId,
            originalLanguage = model.originalLanguage,
            originalTitle = model.originalTitle,
            overview = model.overview,
            popularity = model.popularity,
            posterPath = BuildConfig.URL_IMAGE + (model.posterPath ?: ""),
            productionCompanies = model.productionCompanies?.map {
                productionCompanyItemMapper.mapToPresentation(it)
            },
            productionCountries = model.productionCountries?.map {
                productionCountryItemMapper.mapToPresentation(it)
            },
            releaseDate = if (model.releaseDate != null) {
                simpleDateFormat.parse(model.releaseDate!!)
            } else {
                null
            },
            revenue = model.revenue,
            runtime = model.runtime,
            spokenLanguages = model.spokenLanguages?.map {
                spokenLanguageItemMapper.mapToPresentation(it)
            },
            status = model.status,
            tagline = model.tagline,
            title = model.title,
            video = model.video,
            voteAverage = (model.voteAverage ?: 0.0) / 2,
            voteCount = model.voteCount
        )
    }

}

