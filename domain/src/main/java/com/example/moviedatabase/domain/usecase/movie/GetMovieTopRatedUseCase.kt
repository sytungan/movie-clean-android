package com.example.moviedatabase.domain.usecase.movie

import com.example.moviedatabase.domain.model.Movie
import com.example.moviedatabase.domain.repository.MovieRepository
import com.example.moviedatabase.domain.usecase.UseCase
import javax.inject.Inject

class GetMovieTopRatedUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) : UseCase<GetMovieTopRatedUseCase.Params, List<Movie>>() {

    override suspend fun createObservable(params: Params?): List<Movie> {
        return when (params) {
            null -> error(Throwable(message = "Params input not null"))
            else -> movieRepository.getMovieListTopRated(params.page)
        }
    }

    data class Params(val page: Int)
}
