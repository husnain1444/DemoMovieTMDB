package com.example.mvvm_hilt_db_retrofit_room.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_hilt_db_retrofit_room.models.ProductsItem
import com.example.mvvm_hilt_db_retrofit_room.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ProductRepository): ViewModel() {

    val productsLiveData: LiveData<List<ProductsItem>>
        get() = repository.products

//    init {
//        viewModelScope.launch {
//            repository.getAllProducts()
//        }
//    }

    fun loadDataFromAPI() {
        viewModelScope.launch {
            repository.getAllProducts()
        }
    }

}