package com.example.moviedatabase.ui.moviedetail

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedatabase.R
import com.example.moviedatabase.base.BaseFragment
import com.example.moviedatabase.databinding.FragmentMovieDetailBinding
import com.example.moviedatabase.extension.singleClickListener
import com.example.moviedatabase.ui.moviedetail.adapter.MovieCommentAdapter
import com.example.moviedatabase.ui.moviedetail.adapter.MovieCreditAdapter
import com.example.moviedatabase.ui.moviedetail.adapter.MovieRecommendationAdapter
import com.example.moviedatabase.ui.moviedetail.adapter.MovieVideoAdapter
import com.example.moviedatabase.widget.NonDividerLastItemDecorator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : BaseFragment<FragmentMovieDetailBinding, MovieDetailViewModel>() {

    private var movieVideoAdapter: MovieVideoAdapter? = null
    private var movieCreditAdapter: MovieCreditAdapter? = null
    private var movieCommentAdapter: MovieCommentAdapter? = null
    private var movieRecommendationAdapter: MovieRecommendationAdapter? = null

    override val layoutId: Int = R.layout.fragment_movie_detail

    override val viewModel: MovieDetailViewModel by viewModels()

    private val args: MovieDetailFragmentArgs by navArgs()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.apply {
            movieVideosItem.observe(viewLifecycleOwner, Observer { movieVideosItem ->
                movieVideosItem.results?.let { movieVideoAdapter?.submitList(it) }
            })

            movieCreditsItem.observe(viewLifecycleOwner, Observer { movieCreditsItem ->
                movieCreditsItem.castItem?.let { movieCreditAdapter?.submitList(it) }
            })

            movieRecommendations.observe(viewLifecycleOwner, Observer {
                movieRecommendationAdapter?.submitList(it)
            })

            movieCommentsItem.observe(viewLifecycleOwner, Observer { movieCommentsItem ->
                movieCommentAdapter?.submitList(movieCommentsItem)
            })

            val movieId = args.idMovie
            if (movieId == -1) {
                findNavController().navigateUp()
            } else {
                pageRecommendations = 1
                getMovieDetail(movieId)
                getMovieVideos(movieId)
                getMovieCredits(movieId)
                getMovieComments(movieId)
                getMovieRecommendations(movieId, pageRecommendations)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.apply {
            layoutInformation.buttonBack.singleClickListener({
                findNavController().navigateUp()
            })

            layoutYourRate.ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
                viewModel?.rating?.value = rating
            }

            movieVideoAdapter = MovieVideoAdapter()
            layoutVideo.recyclerVideo.adapter = movieVideoAdapter

            movieCreditAdapter = MovieCreditAdapter()
            layoutSeriesCast.recyclerSeriesCast.adapter = movieCreditAdapter

            movieCommentAdapter = MovieCommentAdapter()
            layoutComments.recyclerComments.adapter = movieCommentAdapter
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.div_movie_comment
            )?.let { dividerDrawable ->
                layoutComments.recyclerComments.addItemDecoration(
                    NonDividerLastItemDecorator(
                        divider = dividerDrawable,
                        marginStart = resources.getDimension(R.dimen.dp_66).toInt()
                    )
                )
            }

            movieRecommendationAdapter = MovieRecommendationAdapter()
            layoutRecommendations.recyclerRecommendations.adapter = movieRecommendationAdapter

            layoutRecommendations.recyclerRecommendations.addOnScrollListener(
                object : RecyclerView.OnScrollListener() {
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        super.onScrolled(recyclerView, dx, dy)
                        val linearLayoutManager = recyclerView.layoutManager
                        if (linearLayoutManager is LinearLayoutManager) {
                            viewModel?.apply {
                                val movieLastItem =
                                    (movieRecommendations.value?.size ?: 0) - 1
                                if (movieLastItem > 0) {
                                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == movieLastItem) {
                                        pageRecommendations++
                                        getMovieRecommendations(args.idMovie, pageRecommendations)
                                    }
                                }
                            }
                        }
                    }
                })

        }
    }
}
