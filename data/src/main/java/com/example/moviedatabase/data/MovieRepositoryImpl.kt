package com.example.moviedatabase.data

import com.example.moviedatabase.data.model.*
import com.example.moviedatabase.data.remote.api.MovieApi
import com.example.moviedatabase.domain.model.*
import com.example.moviedatabase.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi,
    private val movieEntityMapper: MovieEntityMapper,
    private val genreEntityMapper: GenreEntityMapper,
    private val movieDetailEntityMapper: MovieDetailEntityMapper,
    private val movieVideosEntityMapper: MovieVideosEntityMapper,
    private val movieCreditsEntityMapper: MovieCreditsEntityMapper,
    private val movieCommentEntityMapper: MovieCommentEntityMapper
) : MovieRepository {
    override suspend fun getMovieListPopular(page: Int): List<Movie> {
        return movieApi.getMovieListPopular(page).results.map { movie ->
            movieEntityMapper.mapToDomain(movie)
        }
    }

    override suspend fun getMovieListTopRated(page: Int): List<Movie> {
        return movieApi.getMovieListTopRated(page).results.map { movie ->
            movieEntityMapper.mapToDomain(movie)

        }
    }

    override suspend fun getMovieListUpcoming(page: Int): List<Movie> {
        return movieApi.getMovieListUpcoming(page).results.map { movie ->
            movieEntityMapper.mapToDomain(movie)

        }
    }

    override suspend fun getMovieGenres(): List<Genre> {
        return movieApi.getMovieGenres().genres?.map { genre ->
            genreEntityMapper.mapToDomain(genre)
        } ?: emptyList()
    }

    override suspend fun getMovieDetail(movieId: Int): MovieDetail {
        return movieDetailEntityMapper.mapToDomain(movieApi.getMovieDetail(movieId))
    }

    override suspend fun getMovieVideos(movieId: Int): MovieVideos {
        return movieVideosEntityMapper.mapToDomain(movieApi.getMovieVideos(movieId))
    }

    override suspend fun getMovieCredits(movieId: Int): MovieCredits {
        return movieCreditsEntityMapper.mapToDomain(movieApi.getMovieCredits(movieId))
    }

    override suspend fun getMovieComments(movieId: Int): List<MovieComment> {
        return movieApi.getMovieComments(movieId).results.map { response ->
            movieCommentEntityMapper.mapToDomain(response)
        }
    }

    override suspend fun getMovieRecommendations(movieId: Int, page: Int): List<Movie> {
        return movieApi.getMovieRecommendations(movieId, page).results.map { movie ->
            movieEntityMapper.mapToDomain(movie)
        }
    }
}
