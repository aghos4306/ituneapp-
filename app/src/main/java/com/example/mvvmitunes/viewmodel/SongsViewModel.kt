package com.example.mvvmitunes.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmitunes.model.MusicResponse
import com.example.mvvmitunes.model.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SongsViewModel(
    val repository: Repository
) : ViewModel() {
    val songsLiveData = MutableLiveData<MusicResponse>()

    init {

    }

    fun getMusicResponse(search: String) {
        CoroutineScope(Dispatchers.Main).launch {
            val musicResponse = repository.getSongs(search)
            if(musicResponse.isSuccessful) {
                songsLiveData.postValue(musicResponse.body())
            } else {
                Log.d("response_error", musicResponse.errorBody().toString())
            }
        }
    }
}