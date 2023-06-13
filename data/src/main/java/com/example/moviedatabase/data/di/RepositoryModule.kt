package com.example.moviedatabase.data.di

import android.content.Context
import com.example.moviedatabase.data.Constants
import com.example.moviedatabase.data.MovieRepositoryImpl
import com.example.moviedatabase.data.local.pref.AppPrefs
import com.example.moviedatabase.data.local.pref.PrefHelper
import com.example.moviedatabase.domain.repository.MovieRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Provides
    @DatabaseInfo
    fun providerDatabaseName(): String {
        return Constants.DATABASE_NAME
    }

    @Provides
    @Singleton
    fun providePrefHelper(appPrefs: AppPrefs): PrefHelper {
        return appPrefs
    }

    @Provides
    @Singleton
    fun providerAppPrefs(context: Context): AppPrefs {
        return AppPrefs(context, Gson())
    }

    @Provides
    @Singleton
    fun providerMovieRepository(repository: MovieRepositoryImpl): MovieRepository {
        return repository
    }
}
