package com.example.catbreeds.room

import androidx.lifecycle.LiveData
import com.example.catbreeds.model.Breed
import com.example.catbreeds.model.Likes

class LikedCatsRepository(private val catsDao : LikedCatsDao) {

    val readAllData: LiveData<List<Breed>> = catsDao.readAllData()

    fun addCats(likes : Breed) {
        catsDao.addCat(likes)
    }
}