package com.example.movies.di

import android.content.Context
import androidx.room.Room
import com.example.movies.room_db.MovieDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesFakerDatabase(@ApplicationContext context: Context): MovieDB {
        return Room.databaseBuilder(context = context, MovieDB::class.java, "MoviesDB").build()
    }
}