package com.example.catbreeds.retrofit

import com.example.catbreeds.retrofit.RetrofitService

class MainRepository (private val retrofitService: RetrofitService) {

    fun getBreeds(searchText : String,id : String) = retrofitService.getBreeds(searchText,id)
    fun getDefaultBreeds() = retrofitService.getDefaultBreeds()
}