package com.example.moviedatabase.ui.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.example.moviedatabase.base.BaseViewModel
import com.example.moviedatabase.domain.usecase.movie.*
import com.example.moviedatabase.extension.toMMMMyyyy
import com.example.moviedatabase.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val getMovieVideosUseCase: GetMovieVideosUseCase,
    private val getMovieCreditsUseCase: GetMovieCreditsUseCase,
    private val getMovieCommentsUseCase: GetMovieCommentsUseCase,
    private val getMovieRecommendationsUseCase: GetMovieRecommendationsUseCase,
    private val movieDetailItemMapper: MovieDetailItemMapper,
    private val movieVideosItemMapper: MovieVideosItemMapper,
    private val movieCreditsItemMapper: MovieCreditsItemMapper,
    private val movieCommentItemMapper: MovieCommentItemMapper,
    private val movieItemMapper: MovieItemMapper
) : BaseViewModel() {

    var pageRecommendations = 1

    val movieDetailItem = MutableLiveData<MovieDetailItem>()

    val releaseDate = Transformations.map(movieDetailItem) {
        it.releaseDate?.toMMMMyyyy()
    }
    val genres: LiveData<List<String>> = Transformations.map(movieDetailItem) {
        it.genres?.map { genre -> (genre.name ?: "") }?.take(MAX_GENRE_DISPLAYED) ?: listOf()
    }
    val isExpandingOverview = MutableLiveData<Boolean>().apply {
        value = false
    }

    val rating = MutableLiveData<Float>().apply {
        value = 0.0f
    }

    val movieVideosItem = MutableLiveData<MovieVideosItem>()

    val movieCreditsItem = MutableLiveData<MovieCreditsItem>()

    val movieCommentsItem = MutableLiveData<List<MovieCommentItem>>()

    val movieRecommendations = MutableLiveData<List<MovieItem>>()

    fun expandOverview() {
        isExpandingOverview.value = isExpandingOverview.value?.not()
    }

    fun getMovieDetail(movieId: Int) {
        viewModelScope.launch {
            try {
                movieDetailItem.value = movieDetailItemMapper.mapToPresentation(
                    getMovieDetailUseCase.createObservable(GetMovieDetailUseCase.Params(movieId))
                )
            } catch (e: Exception) {
                hideLoading()
                setThrowable(e)
            }
        }
    }

    fun getMovieVideos(movieId: Int) {
        viewModelScope.launch {
            try {
                movieVideosItem.value = movieVideosItemMapper.mapToPresentation(
                    getMovieVideosUseCase.createObservable(GetMovieVideosUseCase.Params(movieId))
                )
            } catch (e: Exception) {
                setThrowable(e)
            }
        }
    }

    fun getMovieCredits(movieId: Int) {
        viewModelScope.launch {
            try {
                movieCreditsItem.value = movieCreditsItemMapper.mapToPresentation(
                    getMovieCreditsUseCase.createObservable(GetMovieCreditsUseCase.Params(movieId))
                )
            } catch (e: Exception) {
                setThrowable(e)
            }
        }
    }

    fun getMovieComments(movieId: Int) {
        viewModelScope.launch {
            try {
                movieCommentsItem.value =
                    getMovieCommentsUseCase.createObservable(GetMovieCommentsUseCase.Params(movieId))
                        .map {
                            movieCommentItemMapper.mapToPresentation(it)
                        }.take(MAX_COMMENTS_DISPLAYED)

            } catch (e: Exception) {
                setThrowable(e)
            }
        }
    }

    fun getMovieRecommendations(movieId: Int, page: Int) {
        viewModelScope.launch {
            try {
                val movies =
                    getMovieRecommendationsUseCase.createObservable(
                        GetMovieRecommendationsUseCase.Params(
                            movieId, page
                        )
                    )
                        .map { movieItem ->
                            movieItemMapper.mapToPresentation(movieItem)
                        }
                val listMovie = ArrayList<MovieItem>()
                listMovie.addAll(movieRecommendations.value ?: emptyList())
                listMovie.addAll(movies)
                movieRecommendations.value = listMovie
            } catch (e: Exception) {
                setThrowable(e)
            }
        }
    }

    companion object {
        private const val MAX_GENRE_DISPLAYED = 2
        private const val MAX_COMMENTS_DISPLAYED = 3
    }
}

