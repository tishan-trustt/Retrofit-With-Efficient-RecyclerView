package com.example.retrofitdemo2.api

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper{
    companion object{
        val base_url = "https://jsonplaceholder.typicode.com/"

        @Volatile
        var INSTANCE :Retrofit? = null

        fun getInstance(context: Context):Retrofit{
            if(INSTANCE == null){
                synchronized(this){
                    INSTANCE = Retrofit
                        .Builder()
                        .baseUrl(base_url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}