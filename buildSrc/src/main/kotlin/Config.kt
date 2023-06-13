object Versions {
    const val kotlin = "1.6.0"
    internal const val androidPlugin = "4.2.0"

    internal const val androidxCore = "1.1.0"
    internal const val archCore = "2.1.0"
    internal const val room = "2.4.0-alpha03"
    internal const val lifecycle = "2.2.0-alpha04"
    internal const val lifecycleCommonJava8 = "2.1.0"
    internal const val lifecycleSaved = "1.0.0-alpha04"
    internal const val support = "1.1.0"
    internal const val supportRecyclerView = "1.1.0-beta04"
    internal const val supportRecyclerViewSelection = "1.1.0-alpha06"
    internal const val supportCardView = "1.0.0"
    internal const val supportLegacy = "1.0.0"
    internal const val supportDesign = "1.1.0-alpha10"

    internal const val glide = "4.9.0"

    internal const val junit = "4.12"
    internal const val espresso = "3.1.0-alpha4"
    internal const val mockito = "2.7.19"
    internal const val mockitoAll = "1.10.19"
    internal const val hamcrest = "1.3"
    internal const val atslRunner = "1.1.0-alpha1"
    internal const val atslRules = "1.1.0-alpha1"
    internal const val mockWebserver = "3.8.1"
    internal const val robolectric = "4.3"

    internal const val retrofit = "2.9.0"
    internal const val okLogging = "3.9.0"

    internal const val constraintLaout = "2.0.0-beta2"

    internal const val rxJava = "2.2.9"
    internal const val rxAndroid = "2.1.0"

    internal const val timber = "4.7.1"

    internal const val easyPermission = "3.0.0"
    internal const val navigation = "2.2.0-alpha02"
    internal const val navigationSafe = "2.1.0-alpha05"

    internal const val exo = "2.8.2"
    internal const val coroutines = "1.6.1"

    internal const val hilt = "2.38.1"
    internal const val fragmentKtx = "1.3.0-alpha01"

    internal const val googleService = "4.3.0"
    internal const val fabric = "1.31.0"

    internal const val firebaseCore = "17.2.0"
    internal const val firebaseAnalytics = "17.2.0"
    internal const val crashAnalytics = "2.10.1"

    internal const val circleImageView = "3.1.0"
}

object Url {
    const val fabric = "https://maven.fabric.io/public"
    const val sonatype = "https://oss.sonatype.org/content/repositories/snapshots"
    const val jitpack = "https://jitpack.io"
}

object BuildPlugins {
    const val androidPlugin = "com.android.tools.build:gradle:${Versions.androidPlugin}"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val navigationSafe =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationSafe}"
    const val googleService = "com.google.gms:google-services:${Versions.googleService}"
    const val fabric = "io.fabric.tools:gradle:${Versions.fabric}"
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
}

object Android {
    const val minSdk = 21
    const val targetSdk = 31
    const val applicationId = "com.example.moviedatabase"
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object GradlePlugins {
    const val android = "com.android.application"
    const val kotlin = "kotlin"
    const val kotlinAndroid = "android"
    const val kotlinExt = "android.extensions"
    const val kotlinApt = "kapt"
    const val javaLib = "java-library"
    const val androidLib = "com.android.library"
    const val navigationSafe = "androidx.navigation.safeargs"
    const val navigationSafeKotlin = "androidx.navigation.safeargs.kotlin"
    const val fabric = "io.fabric"
    const val playService = "com.google.gms.google-services"
    const val hilt = "dagger.hilt.android.plugin"
}

object Modules {
    const val domain = ":domain"
    const val data = ":data"
}

object AndroidJUnit {
    const val runner = "androidx.test.runner.AndroidJUnitRunner"
}

object BuildType {
    const val debug = "debug"
    const val release = "release"

    const val minifyRelease = false
    const val proguardRelease = "proguard-rules.pro"

    const val minifyDebug = false
    const val proguardDebug = "proguard-rules.pro"
}

object Libs {
    //KTX
    const val ktx = "androidx.core:core-ktx:${Versions.androidxCore}"
    const val archTesting = "androidx.arch.core:core-testing:${Versions.archCore}"
    const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"

    // Support libs
    const val supportAnnotations = "androidx.annotation:annotation:${Versions.support}"
    const val supportAppCompat = "androidx.appcompat:appcompat:${Versions.support}"
    const val supportRecyclerview =
        "androidx.recyclerview:recyclerview:${Versions.supportRecyclerView}"
    const val supportRecyclerviewSelection =
        "androidx.recyclerview:recyclerview-selection:${Versions.supportRecyclerViewSelection}"
    const val supportCardview = "androidx.cardview:cardview:${Versions.supportCardView}"
    const val supportDesign = "com.google.android.material:material:${Versions.supportDesign}"
    const val supportLegacyV4 = "androidx.legacy:legacy-support-v4:${Versions.supportLegacy}"

    // Constraint Layout
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLaout}"

    // databinding compiler
    const val bindingCompiler =
        "androidx.databinding:databinding-compiler:${Versions.androidPlugin}"

    // room database
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomRxjava2 = "androidx.room:room-rxjava2:${Versions.room}"

    // lifecycle
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata:${Versions.lifecycle}"
    const val lifecycleLiveDataKtx =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel:${Versions.lifecycle}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val lifecycleSavedState =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycleSaved}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"

    // Coroutines
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    // retrofit
    const val retrofitRuntime = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofitMock = "com.squareup.retrofit2:retrofit-mock:${Versions.retrofit}"
    const val retrofitAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val okLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okLogging}"

    // Navigation
    const val navigationRuntime = "androidx.navigation:navigation-runtime:${Versions.navigation}"
    const val navigationRuntimeKtx =
        "androidx.navigation:navigation-runtime-ktx:${Versions.navigation}"
    const val navigationFragment = "androidx.navigation:navigation-fragment:${Versions.navigation}"
    const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui:${Versions.navigation}"

    // Glide for image loader
    const val glideRuntime = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    // Permission for AndroidX
    const val permission = "pub.devrel:easypermissions:${Versions.easyPermission}"

    // Timber for logging
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    // JUnit for testing
    const val junit = "junit:junit:${Versions.junit}"

    // KTX testing
    const val kotlinTest = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    const val kotlinAllopen = "org.jetbrains.kotlin:kotlin-allopen:${Versions.kotlin}"

    // Ruler & Runner testing
    const val atslRunner = "androidx.test:runner:$${Versions.atslRunner}"
    const val atslRules = "androidx.test:rules:${Versions.atslRules}"

    // espresso for testing
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso}"
    const val espressoIntents = "androidx.test.espresso:espresso-intents:${Versions.espresso}"

    // robolectric for testing
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"

    // Mockito for testing
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockitoAll = "org.mockito:mockito-all:${Versions.mockitoAll}"
    const val mockitoWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebserver}"

    // Hamcrest for testing
    const val hamcrest = "org.hamcrest:hamcrest-all:${Versions.hamcrest}"

    // Hilt
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCore = "com.google.dagger:hilt-core:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltNavigation = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
    const val hiltLifeCycle = "androidx.hilt:hilt-navigation-fragment:1.0.0-beta01"
    const val hiltCompilerAndroidX = "androidx.hilt:hilt-compiler:1.0.0"

    const val firebaseCore = "com.google.firebase:firebase-core:${Versions.firebaseCore}"
    const val firebaseAnalytics =
        "com.google.firebase:firebase-analytics:${Versions.firebaseAnalytics}"
    const val crashAnalytics = "com.crashlytics.sdk.android:crashlytics:${Versions.crashAnalytics}"
    const val circleImageView = "de.hdodenhof:circleimageview:${Versions.circleImageView}"

    const val metadataJvm = "org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.3.0"
}