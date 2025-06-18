package com.example.movies.room_db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movies.models.Result

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMoviesResult(movies: List<Result>)

    @Query("SELECT * FROM Result")
    suspend fun getMovies(): List<Result>
}