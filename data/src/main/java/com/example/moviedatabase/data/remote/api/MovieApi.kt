package com.example.moviedatabase.data.remote.api

import com.example.moviedatabase.data.model.MovieCreditsEntity
import com.example.moviedatabase.data.model.MovieDetailEntity
import com.example.moviedatabase.data.model.MovieVideosEntity
import com.example.moviedatabase.data.remote.response.GetGenresResponse
import com.example.moviedatabase.data.remote.response.GetMovieCommentsResponse
import com.example.moviedatabase.data.remote.response.GetMovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/popular")
    suspend fun getMovieListPopular(@Query(ApiParams.PAGE) page: Int): GetMovieResponse

    @GET("movie/top_rated")
    suspend fun getMovieListTopRated(@Query(ApiParams.PAGE) page: Int): GetMovieResponse

    @GET("movie/upcoming")
    suspend fun getMovieListUpcoming(@Query(ApiParams.PAGE) page: Int): GetMovieResponse

    @GET("genre/movie/list")
    suspend fun getMovieGenres(): GetGenresResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(@Path(ApiParams.MOVIE_ID) movieId: Int): MovieDetailEntity

    @GET("movie/{movie_id}/videos")
    suspend fun getMovieVideos(@Path(ApiParams.MOVIE_ID) movieId: Int): MovieVideosEntity

    @GET("movie/{movie_id}/credits")
    suspend fun getMovieCredits(@Path(ApiParams.MOVIE_ID) movieId: Int): MovieCreditsEntity

    @GET("movie/{movie_id}/recommendations")
    suspend fun getMovieRecommendations(
        @Path(ApiParams.MOVIE_ID) movieId: Int,
        @Query(ApiParams.PAGE) page: Int
    ): GetMovieResponse

    @GET("movie/{movie_id}/reviews")
    suspend fun getMovieComments(@Path(ApiParams.MOVIE_ID) movieId: Int): GetMovieCommentsResponse
}

object ApiParams {
    const val PAGE = "page"
    const val MOVIE_ID = "movie_id"
}
