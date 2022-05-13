package com.example.catbreeds.retrofit

import com.example.catbreeds.model.Breed
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("breeds?attach_breed=0")
    fun getBreeds(): Call<List<Breed>>
}