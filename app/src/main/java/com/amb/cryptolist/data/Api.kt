package com.amb.cryptolist.data

import com.amb.cryptolist.data.response.CryptoCoinDetailResponse
import com.amb.cryptolist.data.response.CryptoCoinResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CryptoCoinResponse>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinDetail(@Path("coinId") coinId: String): CryptoCoinDetailResponse
}