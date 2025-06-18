package com.example.movies.retrofit

import com.example.movies.models.MovieSearchItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPIs {

    @GET("search/multi")
    suspend fun getMovies(
        @Query("api_key") apiKey: String,
        @Query("query") query: String
    ): Response<MovieSearchItem>
}