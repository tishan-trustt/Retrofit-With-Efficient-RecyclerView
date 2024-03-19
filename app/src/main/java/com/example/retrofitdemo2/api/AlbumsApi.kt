package com.example.retrofitdemo2.api

import com.example.retrofitdemo2.models.Albums
import com.example.retrofitdemo2.models.AlbumsItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface AlbumsApi {

    @GET("/albums")
    suspend fun getAlbums():Response<Albums>

    @GET("/albums")
    suspend fun getSortedAlbums(@Query("userId") id:Int):Response<Albums>

    @GET("/albums/{id}")
    suspend fun getAlbum(@Path(value = "id")id:Int):Response<AlbumsItem>
}