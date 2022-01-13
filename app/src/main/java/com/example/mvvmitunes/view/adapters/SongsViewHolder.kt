package com.example.mvvmitunes.view.adapters

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmitunes.R

class SongsViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val songImage: ImageView = view.findViewById(R.id.song_image)
    val songName: TextView = view.findViewById(R.id.song_name)
    val artistName: TextView = view.findViewById(R.id.artist_name)
    val price: TextView = view.findViewById(R.id.price)

    fun bindData(
        context: Context,
        imageUrl: String, name: String, artist: String, priceValue: Double?
    ) {
        imageUrl.let {
            Glide.with(context).load(imageUrl).into(songImage)
        }
        songName.text = name
        artistName.text = artist
        priceValue.let {
            "$${it}".also { price.text = it }
        }
    }
}