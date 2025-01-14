package com.amb.cryptolist.domain.usecase

import com.amb.cryptolist.common.Response
import com.amb.cryptolist.data.repository.CoinRepositoryImpl
import com.amb.cryptolist.domain.model.CryptoCoin
import com.amb.cryptolist.domain.repository.CoinRepository

class GetCoinsUseCase(
    private val repositoryImpl: CoinRepository = CoinRepositoryImpl()
) {
    suspend operator fun invoke(): Response<List<CryptoCoin>> {
        return try {
            val response = repositoryImpl.getCoins().map { it.toCryptoCoin() }
            Response.Success(response)
        } catch (e: Exception) {
            Response.Error(e)
        }
    }
}