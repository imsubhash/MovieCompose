package com.example.moviecompose.movielistpage

import androidx.paging.PagingData
import com.example.moviecompose.model.MovieResult

sealed class MovieUiState {
    data object Loading : MovieUiState()
    data class Success(val movieResponse: PagingData<MovieResult>) : MovieUiState()
    data class Error(val message: String) : MovieUiState()
}