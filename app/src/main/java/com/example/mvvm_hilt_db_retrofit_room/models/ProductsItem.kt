package com.example.mvvm_hilt_db_retrofit_room.models

import androidx.room.Entity
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey

@Entity
data class ProductsItem(
//    @PrimaryKey val primaryKey: PrimaryKey,
    val category: String,
    val description: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)