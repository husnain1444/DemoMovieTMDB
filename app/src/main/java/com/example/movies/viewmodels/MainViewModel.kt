package com.example.movies.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.models.Result
import com.example.movies.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MovieRepository): ViewModel() {

    private val _selectedResult = MutableStateFlow<Result?>(null)
    val selectedResult: StateFlow<Result?> = _selectedResult

    fun setResult(result: Result) {
        _selectedResult.value = result
    }

    val moviesLiveData: LiveData<List<Result>>
        get() = repository.movies

    val moviesClosureLiveData: LiveData<Map<String, List<Result>>>
        get() = repository.moviesClosure

    fun loadDataFromAPI(query: String) {
        viewModelScope.launch {
            repository.getAllMovies(query)
        }
    }

}