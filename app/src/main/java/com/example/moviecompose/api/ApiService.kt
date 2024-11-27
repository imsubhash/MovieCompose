package com.example.moviecompose.api

import com.example.moviecompose.model.MovieDetails
import com.example.moviecompose.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("3/movie/now_playing")
    suspend fun getMovies(
        @Query("language") language: String,
        @Query("page") page: Int
    ): Response<MovieResponse>

    @GET("3/movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id: Int,
        @Query("language") language: String,
    ): Response<MovieDetails>
}
