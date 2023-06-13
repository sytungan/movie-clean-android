package com.example.moviedatabase.data.remote.interceptor

import android.content.Context
import com.example.moviedatabase.data.BuildConfig
import com.example.moviedatabase.data.local.pref.AppPrefs
import com.example.moviedatabase.data.model.Token
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor(
    private val context: Context
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val token: Token? = AppPrefs(context, Gson()).getToken()

        var request = chain.request()

        val newUrl = request.url().newBuilder().addQueryParameter(
            "api_key",
            BuildConfig.API_KEY
        ).build()

        request = request?.newBuilder()
            ?.addHeader("Content-Type", "application/json")
            ?.addHeader("Accept", "application/json")
            ?.apply { token?.token?.let { addHeader("Authorization", "Bearer $it") } }
            ?.method(request.method(), request.body())
            ?.url(newUrl)
            ?.build()
        return chain.proceed(request)
    }
}
