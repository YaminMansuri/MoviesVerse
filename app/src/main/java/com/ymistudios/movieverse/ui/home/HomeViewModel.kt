package com.ymistudios.movieverse.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ymistudios.movieverse.data.pojo.Movie
import com.ymistudios.movieverse.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(UIState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnSearchChanged -> {
                _uiState.update { it.copy(search = event.search) }
                getMovieList()
            }

            HomeEvent.GetMovieList -> {
                getMovieList()
            }
        }
    }

    private fun getMovieList() {
        viewModelScope.launch {
            val response = movieRepository.getMovieList(search = _uiState.value.search, page = 1)
            _uiState.update {
                it.copy(movieList = response.data)
            }
        }
    }

    data class UIState(
        val search: String = "",
        val movieList: Movie? = null
    )
}