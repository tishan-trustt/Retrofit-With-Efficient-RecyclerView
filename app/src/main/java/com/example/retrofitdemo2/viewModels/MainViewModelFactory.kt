package com.example.retrofitdemo2.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitdemo2.AlbumRepositary

class MainViewModelFactory(val repo : AlbumRepositary):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModels(repo) as T
    }
}