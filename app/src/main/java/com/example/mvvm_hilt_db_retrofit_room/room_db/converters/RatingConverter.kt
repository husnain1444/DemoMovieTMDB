package com.example.mvvm_hilt_db_retrofit_room.room_db.converters

import androidx.room.TypeConverter
import com.example.mvvm_hilt_db_retrofit_room.models.Rating
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RatingConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromMyObject(myObject: Rating?): String? {
        return gson.toJson(myObject)
    }

    @TypeConverter
    fun toMyObject(json: String?): Rating? {
        val type = object : TypeToken<Rating>() {}.type
        return gson.fromJson(json, type)
    }
}