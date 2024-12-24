package com.example.mvvm_hilt_db_retrofit_room.retrofit

import com.example.mvvm_hilt_db_retrofit_room.models.ProductsItem
import retrofit2.Response
import retrofit2.http.GET

interface FakeAPIs {

    @GET("products")
    suspend fun getProducts(): Response<List<ProductsItem>>
}