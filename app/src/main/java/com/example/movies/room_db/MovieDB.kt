package com.example.movies.room_db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.movies.models.MovieSearchItem
import com.example.movies.models.Result
import com.example.movies.room_db.converters.Converters

@Database(entities = [Result::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class MovieDB: RoomDatabase() {

    abstract fun getMovieDao(): MovieDao
}