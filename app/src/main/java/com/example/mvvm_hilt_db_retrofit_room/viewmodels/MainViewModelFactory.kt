package com.example.mvvm_hilt_db_retrofit_room.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_hilt_db_retrofit_room.repository.ProductRepository
import javax.inject.Inject

//*** No need for Hilt ***

//class MainViewModelFactory @Inject  constructor(private val repository: ProductRepository): ViewModelProvider.Factory {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return MainViewModel(repository) as T
//    }
//}