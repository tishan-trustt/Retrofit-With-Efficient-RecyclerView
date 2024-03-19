package com.example.retrofitdemo2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitdemo2.api.AlbumsApi
import com.example.retrofitdemo2.models.Albums
import retrofit2.Response

class AlbumRepositary(val api : AlbumsApi) {

    val quoteLiveData = MutableLiveData<Albums>()
    val quotes :LiveData<Albums>
        get() = quoteLiveData


    suspend fun getAlbums(){
        val result = api.getAlbums()
        if(result?.body() != null){
            quoteLiveData.postValue(result.body())
        }
    }


}