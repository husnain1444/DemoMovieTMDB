package com.example.mvvm_hilt_db_retrofit_room.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvm_hilt_db_retrofit_room.room_db.FakerDB
import com.example.mvvm_hilt_db_retrofit_room.room_db.FakerDao
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
    fun providesFakerDatabase(@ApplicationContext context: Context): FakerDB {
        return Room.databaseBuilder(context = context, FakerDB::class.java, "FakerDB").build()
    }
}