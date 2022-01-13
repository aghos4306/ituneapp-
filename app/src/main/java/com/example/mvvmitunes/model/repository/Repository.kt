package com.example.mvvmitunes.model.repository

import com.example.mvvmitunes.model.MusicResponse
import com.example.mvvmitunes.network.MusicApiInterface
import com.example.mvvmitunes.network.RetrofitClient
import com.example.mvvmitunes.utils.ENTITY
import com.example.mvvmitunes.utils.LIMIT
import com.example.mvvmitunes.utils.MEDIA
import retrofit2.Response

class Repository {
    suspend fun getSongs(search: String): Response<MusicResponse> {
        return RetrofitClient.getService(MusicApiInterface::class.java)
            .getSongResponse(search, MEDIA, ENTITY, LIMIT)
    }
}