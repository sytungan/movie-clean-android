package com.example.moviedatabase

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import com.example.moviedatabase.crashlytics.CrashlyticsTree
import com.example.moviedatabase.data.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import io.fabric.sdk.android.Fabric
import timber.log.Timber

@HiltAndroidApp
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val crashlytics = CrashlyticsCore.Builder()
            .disabled(BuildConfig.DEBUG)
            .build()
        Fabric.with(
            this,
            Crashlytics.Builder().core(crashlytics).build()
        )

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        Timber.plant(CrashlyticsTree())
    }
}
