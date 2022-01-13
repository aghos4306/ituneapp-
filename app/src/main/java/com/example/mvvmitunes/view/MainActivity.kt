package com.example.mvvmitunes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
//import android.support.v7.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmitunes.R
import com.example.mvvmitunes.databinding.ActivityMainBinding
import com.example.mvvmitunes.model.repository.Repository
import com.example.mvvmitunes.view.adapters.SongsAdapter
import com.example.mvvmitunes.viewmodel.SongsViewModel
import com.example.mvvmitunes.viewmodel.SongsViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var songsRv: RecyclerView
    private lateinit var songsSearch: SearchView
    private lateinit var songsAdapter: SongsAdapter

    private val repository by lazy {
        Repository()
    }

    private val viewmodel by lazy {
        ViewModelProvider(this, SongsViewModelFactory(repository)).get(SongsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        songsRv = findViewById(R.id.songs_rv)
        songsRv.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }

        viewmodel.songsLiveData.observe(this, {
            songsAdapter = SongsAdapter(it.results)
            songsRv.apply {
                adapter = songsAdapter
            }
        })

        viewmodel.getMusicResponse("beatles")
        songsSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    viewmodel.getMusicResponse(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }
}