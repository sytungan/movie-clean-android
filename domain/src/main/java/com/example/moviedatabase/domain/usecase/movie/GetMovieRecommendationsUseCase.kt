package com.example.moviedatabase.domain.usecase.movie

import com.example.moviedatabase.domain.model.Movie
import com.example.moviedatabase.domain.repository.MovieRepository
import com.example.moviedatabase.domain.usecase.UseCase
import javax.inject.Inject

class GetMovieRecommendationsUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) : UseCase<GetMovieRecommendationsUseCase.Params, List<Movie>>() {

    override suspend fun createObservable(params: Params?): List<Movie> {
        return when (params) {
            null -> error(Throwable(message = "Params input not null"))
            else -> movieRepository.getMovieRecommendations(params.movieId, params.page)
        }
    }

    data class Params(val movieId: Int, val page: Int)
}
