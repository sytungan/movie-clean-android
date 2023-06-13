package com.example.moviedatabase.domain.usecase.movie

import com.example.moviedatabase.domain.model.Movie
import com.example.moviedatabase.domain.repository.MovieRepository
import com.example.moviedatabase.domain.usecase.UseCase
import javax.inject.Inject

class GetMovieUpcomingUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) : UseCase<GetMovieUpcomingUseCase.Params, List<Movie>>() {

    override suspend fun createObservable(params: Params?): List<Movie> {
        return when (params) {
            null -> error(Throwable(message = "Params input not null"))
            else -> movieRepository.getMovieListUpcoming(params.page)
        }
    }

    data class Params(val page: Int)
}
