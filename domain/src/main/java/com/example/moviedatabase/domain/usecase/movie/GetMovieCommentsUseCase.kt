package com.example.moviedatabase.domain.usecase.movie

import com.example.moviedatabase.domain.model.MovieComment
import com.example.moviedatabase.domain.repository.MovieRepository
import com.example.moviedatabase.domain.usecase.UseCase
import javax.inject.Inject

class GetMovieCommentsUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) : UseCase<GetMovieCommentsUseCase.Params, List<MovieComment>>() {

    override suspend fun createObservable(params: Params?): List<MovieComment> {
        return when (params) {
            null -> error(Throwable(message = "Params input not null"))
            else -> movieRepository.getMovieComments(params.movieId)
        }
    }

    data class Params(val movieId: Int)
}
