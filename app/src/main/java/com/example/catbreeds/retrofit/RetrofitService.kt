package com.example.catbreeds.retrofit


import com.example.catbreeds.model.Breed
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


interface RetrofitService {

    @GET("breeds/search")
    fun getBreeds(
        @Query("q") searchText : String,
        @Query("api_key") id : String
    ): Call<List<Breed>>

    @GET("breeds/")
    fun getDefaultBreeds(
    ): Call<List<Breed>>

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

