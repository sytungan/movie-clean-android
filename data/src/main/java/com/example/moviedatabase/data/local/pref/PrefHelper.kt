package com.example.moviedatabase.data.local.pref

import com.example.moviedatabase.data.model.Token

interface PrefHelper {
    fun isFirstRun(): Boolean

    fun setFirstRun(boolean: Boolean)

    fun getToken(): Token?

    fun setToken(token: Token)
}