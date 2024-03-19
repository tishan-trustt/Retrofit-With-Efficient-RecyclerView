package com.example.retrofitdemo2.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitdemo2.AlbumRepositary
import com.example.retrofitdemo2.models.Albums
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModels( val repo : AlbumRepositary):ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getAlbums()
        }
    }

    val quote : LiveData<Albums>
        get() = repo.quotes
}