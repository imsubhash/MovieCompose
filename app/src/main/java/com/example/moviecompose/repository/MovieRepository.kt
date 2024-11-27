package com.example.moviecompose.repository

import com.example.moviecompose.api.ApiService
import com.example.moviecompose.util.Constants.LANGUAGE
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getMovies(page: Int) = apiService.getMovies(LANGUAGE, page)

    suspend fun getMovieDetails(id: Int) = apiService.getMovieDetails(id, LANGUAGE)

}