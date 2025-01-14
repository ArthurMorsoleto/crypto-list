package com.amb.cryptolist.domain.repository

import com.amb.cryptolist.data.response.CryptoCoinDetailResponse
import com.amb.cryptolist.data.response.CryptoCoinResponse

interface CoinRepository {
    suspend fun getCoins(): List<CryptoCoinResponse>
    suspend fun getCoinDetail(coinId: String): CryptoCoinDetailResponse
}