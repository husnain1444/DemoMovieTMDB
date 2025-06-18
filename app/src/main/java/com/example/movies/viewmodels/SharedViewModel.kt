package com.example.movies.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SharedMovieViewModel @Inject constructor() : ViewModel() {

    private val _selectedResult = MutableStateFlow<com.example.movies.models.Result?>(null)
    val selectedResult: StateFlow<com.example.movies.models.Result?> = _selectedResult

    fun setResult(result: com.example.movies.models.Result) {
        _selectedResult.value = result
    }
}