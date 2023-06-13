package com.example.moviedatabase.ui.home

import androidx.lifecycle.viewModelScope
import com.example.moviedatabase.base.BaseViewModel
import com.example.moviedatabase.domain.usecase.movie.*
import com.example.moviedatabase.model.GenreItem
import com.example.moviedatabase.model.GenreItemMapper
import com.example.moviedatabase.model.MovieItem
import com.example.moviedatabase.model.MovieItemMapper
import com.example.moviedatabase.util.SingleLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMoviePopularUseCase: GetMoviePopularUseCase,
    private val getMovieUpcomingUseCase: GetMovieUpcomingUseCase,
    private val getMovieTopRatedUseCase: GetMovieTopRatedUseCase,
    private val getMovieRecommendationsUseCase: GetMovieRecommendationsUseCase,
    private val getGenresUseCase: GetGenresUseCase,
    private val movieItemMapper: MovieItemMapper,
    private val genreItemMapper: GenreItemMapper
) : BaseViewModel() {
    val moviesRecommendations = SingleLiveData<List<MovieItem>>()
    val moviesGenres = SingleLiveData<List<GenreItem>>()
    val moviesPopulars = SingleLiveData<List<MovieItem>>()
    val moviesTopRated = SingleLiveData<List<MovieItem>>()
    val moviesUpcoming = SingleLiveData<List<MovieItem>>()
    val movieId = SingleLiveData<Int>().apply { value = -1 }

    var pageRecommendations = 1
    var pagePopulars = 1
    var pageTopRated = 1
    var pageUpcoming = 1

    fun getGenres() {
        if (isLoading.value == false) {
            showLoading()
        }

        viewModelScope.launch {
            try {
                moviesGenres.value = getGenresUseCase.createObservable().map { genre ->
                    genreItemMapper.mapToPresentation(genre)
                }
                hideLoading()
            } catch (e: Exception) {
                hideLoading()
                setThrowable(e)
            }
        }
    }

    fun getMovieListPopular(page: Int) {
        if (isLoading.value == false) {
            showLoading()
        }

        viewModelScope.launch {
            try {
                val movies =
                    getMoviePopularUseCase.createObservable(GetMoviePopularUseCase.Params(page))
                        .map { movieItem ->
                            movieItemMapper.mapToPresentation(movieItem)
                        }
                val listMovie = ArrayList<MovieItem>()
                listMovie.addAll(moviesPopulars.value ?: emptyList())
                listMovie.addAll(movies)
                moviesPopulars.value = listMovie
                hideLoading()
            } catch (e: Exception) {
                hideLoading()
                setThrowable(e)
            }
        }
    }

    fun getMovieListUpcoming(page: Int) {
        if (isLoading.value == false) {
            showLoading()
        }
        viewModelScope.launch {
            try {
                val movies =
                    getMovieUpcomingUseCase.createObservable(GetMovieUpcomingUseCase.Params(page))
                        .map { movieItem ->
                            movieItemMapper.mapToPresentation(movieItem)
                        }
                val listMovie = ArrayList<MovieItem>()
                listMovie.addAll(moviesUpcoming.value ?: emptyList())
                listMovie.addAll(movies)
                moviesUpcoming.value = listMovie
                hideLoading()
            } catch (e: Exception) {
                hideLoading()
                setThrowable(e)
            }
        }
    }

    fun getMovieListTopRated(page: Int) {
        if (isLoading.value == false) {
            showLoading()
        }
        viewModelScope.launch {
            try {
                val movies =
                    getMovieTopRatedUseCase.createObservable(GetMovieTopRatedUseCase.Params(page))
                        .map { movieItem ->
                            movieItemMapper.mapToPresentation(movieItem)
                        }
                val listMovie = ArrayList<MovieItem>()
                listMovie.addAll(moviesTopRated.value ?: emptyList())
                listMovie.addAll(movies)
                moviesTopRated.value = listMovie
                hideLoading()
            } catch (e: Exception) {
                hideLoading()
                setThrowable(e)
            }
        }
    }

    fun getMovieRecommendations(page: Int) {
        if (movieId.value == -1) {
            return
        }
        viewModelScope.launch {
            try {
                val movies =
                    getMovieRecommendationsUseCase.createObservable(
                        GetMovieRecommendationsUseCase.Params(
                            movieId.value!!, page
                        )
                    )
                        .map { movieItem ->
                            movieItemMapper.mapToPresentation(movieItem)
                        }
                val listMovie = ArrayList<MovieItem>()
                listMovie.addAll(moviesRecommendations.value ?: emptyList())
                listMovie.addAll(movies)
                moviesRecommendations.value = listMovie
                hideLoading()
            } catch (e: Exception) {
                hideLoading()
                setThrowable(e)
            }
        }
    }

    fun refreshMoviePage() {
        pageRecommendations = 1
        pagePopulars = 1
        pageTopRated = 1
        pageUpcoming = 1

        moviesRecommendations.value = emptyList()
        moviesPopulars.value = emptyList()
        moviesTopRated.value = emptyList()
        moviesUpcoming.value = emptyList()
    }
}
