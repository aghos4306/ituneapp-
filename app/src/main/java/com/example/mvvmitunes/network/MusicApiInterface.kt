package com.example.mvvmitunes.network

import com.example.mvvmitunes.model.MusicResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicApiInterface {
    @GET("search")
    suspend fun getSongResponse(
        @Query("term") term: String,
        @Query("media") media: String,
        @Query("entity") entity: String,
        @Query("limit") limit: Int
    ): Response<MusicResponse>
}