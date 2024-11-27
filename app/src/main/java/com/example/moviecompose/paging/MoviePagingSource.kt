package com.example.moviecompose.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.moviecompose.model.MovieResult
import com.example.moviecompose.repository.MovieRepository
import javax.inject.Inject

class MoviePagingSource @Inject constructor(private val movieRepository: MovieRepository) :
    PagingSource<Int, MovieResult>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieResult> {
        return try {
            val position = params.key ?: 1
            val response = movieRepository.getMovies(position)
            LoadResult.Page(
                data = response.body()?.results!!,
                prevKey = if (position == 1) null else position.minus(1),
                nextKey = if (position == response.body()?.total_pages) null else position.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MovieResult>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}