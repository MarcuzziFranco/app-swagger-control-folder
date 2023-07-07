package com.example.swaggercontrolfolder.core

import com.example.swaggercontrolfolder.HelpModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface IApiServices {

    @GET
    suspend fun getCheckOnline(@Url url: String): Response<HelpModel>
}