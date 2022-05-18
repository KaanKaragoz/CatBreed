package com.example.catbreeds.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.catbreeds.model.Breed
import com.example.catbreeds.retrofit.MainRepository
import com.example.catbreeds.retrofit.RetrofitService
import com.example.catbreeds.room.LikedCatsDatabase
import com.example.catbreeds.room.LikedCatsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class HomeViewModel(application: Application) : AndroidViewModel(application) {



    val breedlist = MutableLiveData<List<Breed>>()
    val errorMessage = MutableLiveData<String>()
    val repository : RetrofitService
    val readAllData: LiveData<List<Breed>>
    val likeRepository: LikedCatsRepository

    init {
        val likedCatsDao = LikedCatsDatabase.getDatabase(application).catsDao()
        likeRepository = LikedCatsRepository(likedCatsDao)
        readAllData = likeRepository.readAllData
        repository = RetrofitService.create()
    }


    fun handleBreeds( query : String?){
        var response = repository.getDefaultBreeds()
        if (!query.isNullOrEmpty()) {
            // kullanıcı arama yaptı
            response = repository.getBreeds(query,"ae76962b-bfd9-406a-8d88-1a3965c41ad9") //TODO api keyi her seferinde verme, header a ekle
        }
        else {
            //kullanıcı uygulamayı ilk defa açıyor | searchview boş
            response = repository.getDefaultBreeds()
        }
        response.enqueue(object : Callback<List<Breed>>{
            override fun onResponse(call: Call<List<Breed>>, response: Response<List<Breed>>) {
                breedlist.postValue(response.body())
            }
            override fun onFailure(call: Call<List<Breed>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

    fun addCat(cat:Breed) {
        viewModelScope.launch(Dispatchers.IO) {
            likeRepository.addCats(cat)

        }
    }


}