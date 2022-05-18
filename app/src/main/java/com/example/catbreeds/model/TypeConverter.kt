package com.example.catbreeds.model

import androidx.room.TypeConverter

class TypeConverter {

    @TypeConverter
    fun fromItems(bmp: Items): String {
        return bmp.url

    }

    @TypeConverter
    fun fromString(a: String) : Items {
       return Items(a)
    }
}