package com.example.mvvm_hilt_db_retrofit_room.di

import com.example.mvvm_hilt_db_retrofit_room.retrofit.FakeAPIs
import com.example.mvvm_hilt_db_retrofit_room.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesFakeAPI(retrofit: Retrofit): FakeAPIs {
        return retrofit.create(FakeAPIs::class.java)
    }
}