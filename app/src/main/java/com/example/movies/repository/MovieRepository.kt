package com.example.movies.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movies.models.Result
import com.example.movies.retrofit.MovieAPIs
import com.example.movies.room_db.MovieDB
import com.example.movies.utils.Constants
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieAPIs: MovieAPIs, private val movieDB: MovieDB) {

    private val _movies = MutableLiveData<List<Result>>()

    val movies: LiveData<List<Result>>
        get() = _movies

    private val _moviesClosure = MutableLiveData<Map<String, List<Result>>>()
    val moviesClosure: LiveData<Map<String, List<Result>>>
        get() = _moviesClosure

    suspend fun getAllMovies(query: String) {

        val result = movieAPIs.getMovies(Constants.API_KEY, query)
        if(result.isSuccessful && result.body() != null) {
//            movieDB.getMovieDao().insertMoviesResult(result.body()!!.results)
            _movies.postValue(result.body()!!.results)
            _moviesClosure.postValue(result.body()!!.results.groupBy { it.media_type })
        }
    }
}