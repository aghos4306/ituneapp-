package com.example.mvvmitunes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmitunes.model.repository.Repository
import java.lang.IllegalArgumentException

class SongsViewModelFactory(val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SongsViewModel::class.java)) {
            return SongsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}