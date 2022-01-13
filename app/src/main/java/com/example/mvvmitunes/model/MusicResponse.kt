package com.example.mvvmitunes.model

data class MusicResponse(
    val resultCount: Int,
    val results: List<SongInfo>
)
