package com.example.catbreeds.retrofit


import com.example.catbreeds.model.Breed
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface RetrofitService {
    @GET("breeds?attach_breed=0")
    fun getBreeds(): Call<List<Breed>>

    companion object {
        var BASE_URL = "https://api.thecatapi.com/v1/"

        fun create() : RetrofitService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(RetrofitService::class.java)
        }
    }
}

