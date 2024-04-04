# Movie with Clean Architect

## Overview
- This is a sample application that utilizes the Clean Architecture framework and the Movie Database API (https://www.themoviedb.org/documentation/api) to retrieve and display movie information.
- The application is built using Hilt for dependency injection and Coroutines for asynchronous programming.

## User Interface
The user interface consists of two main screens: the Home screen and the Movie Detail screen.

### Home screen
![Home screen](images/home.png "Home screen")

### Movie detail screen
![Movie detail screen](images/movie_details.png "Movie detail screen")

## Building the Application
- Clone the project from the following repository: [https://github.com/hungan1409/TheMovieDirectory.git](https://github.com/sytungan/movie-clean-android/.git)
- Use Android Framework version 3.5.x or greater for compilation and execution.

## Architecture
This example follows the principles of Clean Architecture for developing the project. For more information on Clean Architecture, refer to the following link: [The Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)

### Data Flow
![Data Flow](images/data-flow.png "Data flow")

### Work Flow
![Work Flow](images/work-flow.png "Work flow")

## Libraries Used
- [**Foundation**][0] : Provides components for core system capabilities, Kotlin extensions, multidex support, and automated testing.
  - [**AppCompat**][1]: Ensures graceful degradation on older Android versions.
  - [**Android KTX**][2] Enables writing more concise and idiomatic Kotlin code.
  - [**Test**][4]: Offers an Android testing framework for unit and runtime UI tests.
- [**Architecture**][10]: Offers a collection of libraries for designing robust, testable, and maintainable apps. It includes classes for managing UI component lifecycle and handling data persistence.
  - [**Data Binding**][11]: Allows declarative binding of observable data to UI elements.
  - [**Lifecycle**][12]: Facilitates creating a UI that automatically responds to lifecycle events.
  - [**LiveData**][13]: Enables building data objects that notify views when the underlying database changes.
  - [**Navigation**][14]: Handles all aspects of in-app navigation.
  - [**Room**][16]: Provides access to the app's SQLite database with in-app objects and compile-time checks.
  - [**ViewModel**][17]: Stores UI-related data that persists during app rotations. It also simplifies scheduling asynchronous tasks for optimal execution.
  - [**WorkManager**][18]: Manages background jobs in Android.
- [**UI**][30]: Provides details on using UI components in apps, either together or separately.
  - [**Animations & Transitions**][31]: Allows moving widgets and transitioning between screens.
  - [**Fragment**][34]: Represents a basic unit of composable UI.
  - [**Layout**][35]: Facilitates widget arrangement using different algorithms.
- **Third-party libraries**
  - [**Glide**][90]: Used for image loading.
  - [**Kotlin Coroutines**][91]: Manages background threads with simplified code and reduces the need for callbacks.
  - [**Hilt**][93]: Enables dependency injection.
  - [**Retrofit**][94]: Provides a type-safe HTTP client for Android.
  - [**EasyPermission**][95]: A wrapper library that simplifies basic system permission logic when targeting Android M or higher.
  - [**CircleImageView**][96]: A fast circular ImageView, perfect for profile images.



[0]: https://developer.android.com/jetpack/components
[1]: https://developer.android.com/topic/libraries/support-library/packages#v7-appcompat
[2]: https://developer.android.com/kotlin/ktx
[4]: https://developer.android.com/training/testing/
[10]: https://developer.android.com/jetpack/arch/
[11]: https://developer.android.com/topic/libraries/data-binding/
[12]: https://developer.android.com/topic/libraries/architecture/lifecycle
[13]: https://developer.android.com/topic/libraries/architecture/livedata
[14]: https://developer.android.com/topic/libraries/architecture/navigation/
[16]: https://developer.android.com/topic/libraries/architecture/room
[17]: https://developer.android.com/topic/libraries/architecture/viewmodel
[18]: https://developer.android.com/topic/libraries/architecture/workmanager
[30]: https://developer.android.com/guide/topics/ui
[31]: https://developer.android.com/training/animation/
[34]: https://developer.android.com/guide/components/fragments
[35]: https://developer.android.com/guide/topics/ui/declaring-layout
[90]: https://bumptech.github.io/glide/
[91]: https://github.com/Kotlin/kotlinx.coroutines
[93]: https://dagger.dev/hilt/
[94]: https://github.com/square/retrofit
[95]: https://github.com/googlesamples/easypermissions
[96]: https://github.com/hdodenhof/CircleImageView
