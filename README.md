TMDB App - Android
This is a simple Android application that integrates with The Movie Database (TMDb) API to display a list of currently playing movies, as well as detailed information about each movie. The app is built using modern Android development tools and libraries, including Jetpack Compose, Navigation, Hilt for dependency injection, and Paging 3 for efficient data loading and pagination.

Features
Display Now Playing Movies: The app fetches a list of currently playing movies and shows them on the main screen.
Movie Details: Users can tap on a movie to view detailed information, such as the title, overview, release date, and more.
Paging with Paging 3: Uses the Paging 3 library to load movies in pages, improving performance when displaying large datasets.
Dependency Injection with Hilt: Hilt is used to manage dependencies and simplify the overall architecture of the application.
Jetpack Compose: UI is built using Jetpack Compose, a modern UI toolkit for Android.
Navigation: Jetpack Navigation is used to manage navigation between screens.

Libraries & Tools Used
Jetpack Compose: For building UIs in a declarative way.
Paging 3: For handling pagination and loading large data sets efficiently.
Hilt: For dependency injection.
Retrofit: For making network requests to the TMDb API.
Navigation: For navigating between different screens.
ViewModel: For managing UI-related data in a lifecycle-conscious way.
Coroutine: For handling asynchronous operations.
