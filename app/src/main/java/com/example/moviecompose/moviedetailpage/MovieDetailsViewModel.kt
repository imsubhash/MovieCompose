package com.example.moviecompose.moviedetailpage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviecompose.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<MovieDetailUiState>(MovieDetailUiState.Loading)
    val uiState: StateFlow<MovieDetailUiState> = _uiState.asStateFlow()

    fun loadMovie(movieId: Int) {
        viewModelScope.launch {
            try {
                val response = repository.getMovieDetails(movieId)
                if (response.isSuccessful) {
                    _uiState.value = MovieDetailUiState.Success(response.body()!!)
                } else {
                    _uiState.value = MovieDetailUiState.Error("Failed to load movie: ${response.message()}")
                }

            } catch (e: Exception) {
                _uiState.value = MovieDetailUiState.Error("Failed to load movie: ${e.message}")
            }
        }
    }
}