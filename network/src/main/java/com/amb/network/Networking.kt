package com.amb.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Networking {

    private const val BASE_URL = "https://api.coinpaprika.com/v1/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
