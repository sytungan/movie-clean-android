package com.example.moviedatabase.domain.usecase.movie

import com.example.moviedatabase.domain.model.EmptyParams
import com.example.moviedatabase.domain.model.Genre
import com.example.moviedatabase.domain.repository.MovieRepository
import com.example.moviedatabase.domain.usecase.UseCase
import javax.inject.Inject

class GetGenresUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) : UseCase<EmptyParams, List<Genre>>() {

    override suspend fun createObservable(params: EmptyParams?): List<Genre> {
        return movieRepository.getMovieGenres()
    }
}
