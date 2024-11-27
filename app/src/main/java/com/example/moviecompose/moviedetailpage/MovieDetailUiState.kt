package com.example.moviecompose.moviedetailpage

import com.example.moviecompose.model.MovieDetails

sealed class MovieDetailUiState {
    data object Loading : MovieDetailUiState()
    data class Success(val movie: MovieDetails) : MovieDetailUiState()
    data class Error(val message: String) : MovieDetailUiState()
}