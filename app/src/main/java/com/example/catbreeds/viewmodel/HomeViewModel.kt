package com.example.catbreeds.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.catbreeds.model.Breed
import com.example.catbreeds.retrofit.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel(private val repository: MainRepository) : ViewModel() {

    val breedlist = MutableLiveData<List<Breed>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllBreeds(){
        val response = repository.getBreeds()
        response.enqueue(object : Callback<List<Breed>>{
            override fun onResponse(call: Call<List<Breed>>, response: Response<List<Breed>>) {
                breedlist.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Breed>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

}