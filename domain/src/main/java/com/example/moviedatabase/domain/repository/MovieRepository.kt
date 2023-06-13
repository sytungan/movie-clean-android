package com.example.moviedatabase.domain.repository

import com.example.moviedatabase.domain.model.*

interface MovieRepository {
    suspend fun getMovieListPopular(page: Int): List<Movie>

    suspend fun getMovieListTopRated(page: Int): List<Movie>

    suspend fun getMovieListUpcoming(page: Int): List<Movie>

    suspend fun getMovieGenres(): List<Genre>

    suspend fun getMovieDetail(movieId: Int): MovieDetail

    suspend fun getMovieVideos(movieId: Int): MovieVideos

    suspend fun getMovieCredits(movieId: Int): MovieCredits

    suspend fun getMovieComments(movieId: Int): List<MovieComment>

    suspend fun getMovieRecommendations(movieId: Int, page: Int): List<Movie>
}
