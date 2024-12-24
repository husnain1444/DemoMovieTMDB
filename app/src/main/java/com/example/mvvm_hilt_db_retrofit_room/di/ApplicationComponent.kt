package com.example.mvvm_hilt_db_retrofit_room.di

import android.content.Context
import com.example.mvvm_hilt_db_retrofit_room.MainActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

//***Didn't Need this Component for Hilt ***

//@Singleton
//@Component(modules = [NetworkModule::class, DatabaseModule::class])
//interface ApplicationComponent {
//
//    fun inject(mainActivity: MainActivity)
//
//    @Component.Factory
//    interface Factory{
//        fun create(@BindsInstance context: Context): ApplicationComponent
//    }
//}