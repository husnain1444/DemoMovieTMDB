package com.example.mvvm_hilt_db_retrofit_room.room_db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mvvm_hilt_db_retrofit_room.models.ProductsItem
import com.example.mvvm_hilt_db_retrofit_room.room_db.converters.RatingConverter

@Database(entities = [ProductsItem::class], version = 1, exportSchema = false)
@TypeConverters(RatingConverter::class)
abstract class FakerDB: RoomDatabase() {

    abstract fun getFakerDao(): FakerDao
}