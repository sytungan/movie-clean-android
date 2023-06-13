package com.example.moviedatabase.di.builder

import android.content.Context
import com.example.moviedatabase.MainApplication
import com.example.moviedatabase.data.di.NetworkModule
import com.example.moviedatabase.data.di.RepositoryModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// This module tells a Component which are its subcomponents
// Install this module in Hilt-generated SingletonComponent
@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Singleton
    @Provides
    fun providerContext(@ApplicationContext context: Context): Context {
        return context
    }
}