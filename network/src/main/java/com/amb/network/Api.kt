package com.amb.network

import retrofit2.http.GET

interface Api {

    @GET("/coins")
    suspend fun getCoins()
}