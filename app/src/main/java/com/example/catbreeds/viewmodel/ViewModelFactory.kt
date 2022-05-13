package com.example.catbreeds.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.catbreeds.retrofit.MainRepository
import java.lang.IllegalArgumentException

class ViewModelFactory (private val repository: MainRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            HomeViewModel(this.repository) as T }
        else {
            throw IllegalArgumentException("ViewModel Not Found")
        }

    }

}