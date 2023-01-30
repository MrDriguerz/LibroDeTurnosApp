package com.example.libroturnos

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AbrirConductorMap {
    @GET("conductor")
    fun getWeather(
        @Query("q") cityName: String?,
        @Query("appid") ApiToken: String?
    ): Call<Conductor>
}