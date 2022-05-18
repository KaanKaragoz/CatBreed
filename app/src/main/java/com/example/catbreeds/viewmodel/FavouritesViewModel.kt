package com.example.catbreeds.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catbreeds.model.Breed
import com.example.catbreeds.model.Likes
import com.example.catbreeds.room.LikedCatsDatabase
import com.example.catbreeds.room.LikedCatsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavouritesViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<Breed>>
    private val repository: LikedCatsRepository

    init {
        val likedCatsDao = LikedCatsDatabase.getDatabase(application).catsDao()
        repository = LikedCatsRepository(likedCatsDao)
        readAllData = repository.readAllData
    }

    fun addCat(cat:Breed) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCats(cat)
        }
    }
}