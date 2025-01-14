package com.amb.cryptolist.data

import com.amb.cryptolist.data.response.CryptoCoinResponse
import retrofit2.http.GET

interface Api {

    @GET("/coins")
    suspend fun getCoins(): List<CryptoCoinResponse>
}