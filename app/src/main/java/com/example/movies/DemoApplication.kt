package com.example.movies

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DemoApplication: Application() {

//    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        //*** Didn't need this for Hilt Implementation ***

//        applicationComponent = DaggerApplicationComponent.builder().build()
        //For the Factory provides for Room DB
//        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}