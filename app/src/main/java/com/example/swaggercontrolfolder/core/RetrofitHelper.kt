package com.example.swaggercontrolfolder.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://192.168.1.29:7777")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}