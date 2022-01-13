package com.example.mvvmitunes.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmitunes.R
import com.example.mvvmitunes.model.SongInfo

class SongsAdapter(val songs: List<SongInfo>) : RecyclerView.Adapter<SongsViewHolder>() {
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongsViewHolder {
       context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.song_item, parent, false)
        return SongsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongsViewHolder, position: Int) {
        val currentSong = songs[position]
        currentSong.artworkUrl100?.let {
            holder.bindData(
                context,
                it,
                currentSong.trackName ?: currentSong.collectionName,
                currentSong.artistName,
                currentSong.trackPrice
            )
        }
    }

    override fun getItemCount(): Int {
        return songs.size
    }
}