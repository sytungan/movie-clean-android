package com.example.moviedatabase.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedatabase.R
import com.example.moviedatabase.base.BaseFragment
import com.example.moviedatabase.databinding.FragmentHomeBinding
import com.example.moviedatabase.model.GenreItem
import com.example.moviedatabase.model.MovieItem
import com.example.moviedatabase.ui.home.adapter.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()

    override val layoutId: Int = R.layout.fragment_home

    private var categoryAdapter: CategoryAdapter? = null
    private var popularsAdapter: PopularAdapter? = null
    private var topRatedAdapter: TopRatedAdapter? = null
    private var upcomingAdapter: UpcomingAdapter? = null
    private var recommendationAdapter: RecommendationAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryAdapter =
            CategoryAdapter { genreItem: GenreItem -> onClickMovieCategory(genreItem) }
        popularsAdapter = PopularAdapter { movieItem: MovieItem -> onClickMovie(movieItem) }
        topRatedAdapter = TopRatedAdapter { movieItem: MovieItem -> onClickMovie(movieItem) }
        upcomingAdapter = UpcomingAdapter { movieItem: MovieItem -> onClickMovie(movieItem) }
        recommendationAdapter =
            RecommendationAdapter { movieItem: MovieItem -> onClickMovie(movieItem) }

        viewModel.apply {
            moviesPopulars.observe(viewLifecycleOwner, Observer {
                popularsAdapter?.submitList(it)
            })

            moviesTopRated.observe(viewLifecycleOwner, Observer {
                topRatedAdapter?.submitList(it)
            })

            moviesUpcoming.observe(viewLifecycleOwner, Observer {
                upcomingAdapter?.submitList(it)
            })

            moviesGenres.observe(viewLifecycleOwner, Observer {
                categoryAdapter?.submitList(it)
            })

            moviesRecommendations.observe(viewLifecycleOwner, Observer {
                recommendationAdapter?.submitList(it)
            })

            viewDataBinding.apply {
                recyclerRecommendation.adapter = recommendationAdapter
                recyclerCategory.adapter = categoryAdapter
                recyclerPopular.adapter = popularsAdapter
                recyclerTopRated.adapter = topRatedAdapter
                recyclerUpcoming.adapter = upcomingAdapter
                swipeRefreshLayout.setOnRefreshListener {
                    swipeRefreshLayout.isRefreshing = false
                    onMovieRefreshApi()
                }
            }
            onMovieRefreshApi()
            initScrollListener()
        }
    }

    private fun onMovieRefreshApi() {
        viewModel.apply {
            refreshMoviePage()
            getMovieRecommendations(pageRecommendations)
            getGenres()
            getMovieListPopular(pagePopulars)
            getMovieListTopRated(pageTopRated)
            getMovieListUpcoming(pageUpcoming)
        }
    }

    private fun onClickMovieCategory(gender: GenreItem) {
        // TODO : handler for Category
    }

    private fun onClickMovie(movieItem: MovieItem) {
        viewModel.movieId.value = movieItem.id
        val directions = HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(
            idMovie = movieItem.id ?: 0
        )
        findNavController().navigate(directions)
    }

    private fun initScrollListener() {
        viewDataBinding.apply {
            viewModel?.apply {
                recyclerPopular.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        super.onScrolled(recyclerView, dx, dy)
                        val linearLayoutManager = recyclerView.layoutManager
                        if (linearLayoutManager is LinearLayoutManager) {
                            val movieLastItem = (moviesPopulars.value?.size ?: 0) - 1
                            if (movieLastItem > 0) {
                                if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == movieLastItem) {
                                    pagePopulars++
                                    getMovieListPopular(pagePopulars)
                                }
                            }
                        }

                    }
                })

                recyclerUpcoming.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        super.onScrolled(recyclerView, dx, dy)
                        val linearLayoutManager = recyclerView.layoutManager
                        if (linearLayoutManager is LinearLayoutManager) {
                            val movieLastItem = (moviesUpcoming.value?.size ?: 0) - 1
                            if (movieLastItem > 0) {
                                if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == movieLastItem) {
                                    pageUpcoming++
                                    getMovieListUpcoming(pageUpcoming)
                                }
                            }
                        }

                    }
                })

                recyclerTopRated.addOnScrollListener(
                    object : RecyclerView.OnScrollListener() {
                        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                            super.onScrolled(recyclerView, dx, dy)
                            val linearLayoutManager = recyclerView.layoutManager
                            if (linearLayoutManager is LinearLayoutManager) {
                                val movieLastItem = (moviesTopRated.value?.size ?: 0) - 1
                                if (movieLastItem > 0) {
                                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == movieLastItem) {
                                        pageTopRated++
                                        getMovieListTopRated(pageTopRated)
                                    }
                                }
                            }
                        }
                    })

                recyclerRecommendation.addOnScrollListener(
                    object : RecyclerView.OnScrollListener() {
                        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                            super.onScrolled(recyclerView, dx, dy)
                            val linearLayoutManager = recyclerView.layoutManager
                            if (linearLayoutManager is LinearLayoutManager) {
                                val movieLastItem = (moviesRecommendations.value?.size ?: 0) - 1
                                if (movieLastItem > 0) {
                                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == movieLastItem) {
                                        pageRecommendations++
                                        getMovieRecommendations(pageRecommendations)
                                    }
                                }
                            }
                        }
                    })
            }
        }
    }
}
