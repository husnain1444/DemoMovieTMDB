package com.example.mvvm_hilt_db_retrofit_room.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_hilt_db_retrofit_room.models.ProductsItem
import com.example.mvvm_hilt_db_retrofit_room.retrofit.FakeAPIs
import com.example.mvvm_hilt_db_retrofit_room.room_db.FakerDB
import com.example.mvvm_hilt_db_retrofit_room.room_db.FakerDao
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakeAPIs: FakeAPIs, private val fakerDB: FakerDB) {

    private val _products = MutableLiveData<List<ProductsItem>>()

    val products: LiveData<List<ProductsItem>>
        get() = _products

    suspend fun getAllProducts() {
        val result = fakeAPIs.getProducts()
        if(result.isSuccessful && result.body() != null) {
            fakerDB.getFakerDao().insertProductItems(result.body()!!)
            _products.postValue(result.body())
        }
    }
}