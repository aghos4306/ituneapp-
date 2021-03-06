package com.example.mvvmitunes.model

data class SongInfo(
    val artistId: Int,
    val artistName: String,
    val artistViewUrl: String,
    val artworkUrl100: String?,
    val artworkUrl60: String?,
    val collectionCensoredName: String,
    val collectionExplicitness: String,
    val collectionId: Int,
    val collectionName: String,
    val trackName: String?,
    val collectionPrice: Double,
    val collectionViewUrl: String,
    val country: String,
    val currency: String,
    val description: String,
    val previewUrl: String,
    val primaryGenreName: String,
    val releaseDate: String,
    val trackCount: Int,
    val wrapperType: String,
    val trackPrice: Double?
)
