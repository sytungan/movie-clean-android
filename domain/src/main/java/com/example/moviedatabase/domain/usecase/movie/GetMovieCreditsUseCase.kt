package com.example.moviedatabase.domain.usecase.movie

import com.example.moviedatabase.domain.model.MovieCredits
import com.example.moviedatabase.domain.repository.MovieRepository
import com.example.moviedatabase.domain.usecase.UseCase
import javax.inject.Inject

class GetMovieCreditsUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) : UseCase<GetMovieCreditsUseCase.Params, MovieCredits>() {

    override suspend fun createObservable(params: Params?): MovieCredits {
        return when (params) {
            null -> error(Throwable(message = "Params input not null"))
            else -> movieRepository.getMovieCredits(params.movieId)
        }
    }

    data class Params(val movieId: Int)
}
