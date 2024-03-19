package com.example.retrofitdemo2

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo2.api.AlbumsApi
import com.example.retrofitdemo2.api.RetrofitHelper
import com.example.retrofitdemo2.models.Albums
import com.example.retrofitdemo2.models.AlbumsItem
import com.example.retrofitdemo2.recycleView.MyRecyclerViewAdapter
import com.example.retrofitdemo2.viewModels.MainViewModelFactory
import com.example.retrofitdemo2.viewModels.MainViewModels

class MainActivity : AppCompatActivity() {
    private lateinit var viewModels: MainViewModels
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val api = RetrofitHelper.getInstance(this).create(AlbumsApi::class.java)
        val repo = AlbumRepositary(api)
        viewModels = ViewModelProvider(this,MainViewModelFactory(repo)).get(MainViewModels::class.java)



        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = MyRecyclerViewAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val x: MutableList<AlbumsItem> = mutableListOf() // Initialize an empty MutableList
        viewModels.quote.observe(this, Observer {


            // Clear the previous items when new items arrive
            x.clear()
            // Add all items from the albums list to the mutable list x
            x.addAll(it)
            adapter.submitList(x)
        })


        recyclerView.adapter = adapter


    }
}