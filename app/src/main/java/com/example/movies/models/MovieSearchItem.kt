package com.example.movies.models

import androidx.room.Entity
import androidx.room.PrimaryKey

data class MovieSearchItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)