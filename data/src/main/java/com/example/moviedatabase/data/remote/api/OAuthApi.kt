package com.example.moviedatabase.data.remote.api

import com.example.moviedatabase.data.model.Token
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface OAuthApi {

    @POST("/oauth/token")
    @FormUrlEncoded
    fun refreshToken(
        @Field("refresh_token") grantType: String
    ): Call<Token>
}