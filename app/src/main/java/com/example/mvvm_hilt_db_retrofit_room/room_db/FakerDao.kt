package com.example.mvvm_hilt_db_retrofit_room.room_db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm_hilt_db_retrofit_room.models.ProductsItem

@Dao
interface FakerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductItems(productsItem: List<ProductsItem>)

    @Query("SELECT * FROM ProductsItem")
    suspend fun getProductItems(): List<ProductsItem>
}