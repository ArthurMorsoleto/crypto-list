package com.amb.cryptolist.data.repository

import com.amb.cryptolist.data.Api
import com.amb.cryptolist.data.ApiClient
import com.amb.cryptolist.data.response.CryptoCoinResponse
import com.amb.cryptolist.domain.repository.CoinRepository

class CoinRepositoryImpl(
    private val api: Api = ApiClient.service
) : CoinRepository {

    override suspend fun getCoins(): List<CryptoCoinResponse> {
        return api.getCoins()
    }
}