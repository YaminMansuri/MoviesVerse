package com.ymistudios.movieverse.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ymistudios.movieverse.data.pojo.Movie
import com.ymistudios.movieverse.data.repository.MovieRepository
import com.ymistudios.movieverse.ui.movie.movietype.MovieType
import com.ymistudios.movieverse.ui.movie.movietype.MovieTypeListRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val movieList
        get() = flow {
            emit(
                movieRepository.getMovieList(
                    search = _uiState.value.search,
                    type = _uiState.value.selectedMovieType.type
                )
            )
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)

    private val _uiState = MutableStateFlow(UIState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnSearchChanged -> {
                _uiState.update { it.copy(search = event.search) }
                getMovieList()
            }

            is HomeEvent.OnMovieTypeSelected -> {
                selectSingleMovieType(event.movieType)
            }

            HomeEvent.GetMovieList -> {
                getMovieList()
            }
        }
    }

    private fun selectSingleMovieType(movieType: MovieType) {
        _uiState.update { uiState ->
            var selectedMovieType = uiState.selectedMovieType
            val movieTypeList = uiState.movieTypeList.map {
                if (it.type == movieType.type) {
                    selectedMovieType = it
                    it.copy(isSelected = true)
                } else it.copy(isSelected = false)
            }
            uiState.copy(
                movieTypeList = movieTypeList,
                selectedMovieType = selectedMovieType
            )
        }
    }

    private fun getMovieList() {
        _uiState.update { it.copy(loading = true) }
        viewModelScope.launch {
            movieList.collect { response ->
                _uiState.update {
                    it.copy(movie = response?.data, error = response?.error, loading = false)
                }
            }
        }
    }

    data class UIState(
        val search: String = "",
        val movieTypeList: List<MovieType> = MovieTypeListRepo.getMovieTypeList(),
        val selectedMovieType: MovieType = movieTypeList.first(),
        val movie: Movie? = null,
        val loading: Boolean = false,
        val error: String? = null
    )
}