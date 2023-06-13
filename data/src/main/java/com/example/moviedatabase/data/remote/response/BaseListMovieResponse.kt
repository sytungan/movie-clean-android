package com.example.moviedatabase.data.remote.response

import com.google.gson.annotations.SerializedName
import java.util.*

open class BaseListMovieResponse<T> {
    @SerializedName("page")
    var page: Int? = 0

    @SerializedName("total_results")
    var totalResults: Int? = null

    @SerializedName("total_pages")
    var totalPages: Int? = null

    @SerializedName("results")
    var results = ArrayList<T>()
}
