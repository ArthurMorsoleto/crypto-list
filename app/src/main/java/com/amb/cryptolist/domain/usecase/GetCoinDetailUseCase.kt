package com.amb.cryptolist.domain.usecase

import com.amb.cryptolist.common.Response
import com.amb.cryptolist.data.repository.CoinRepositoryImpl
import com.amb.cryptolist.domain.model.CryptoCoinDetail
import com.amb.cryptolist.domain.repository.CoinRepository

class GetCoinDetailUseCase(
    private val repository: CoinRepository = CoinRepositoryImpl()
) {
    suspend operator fun invoke(coinId: String): Response<CryptoCoinDetail> {
        try {
            val coinDetail = repository.getCoinDetail(coinId).toCoinDetail()
            return Response.Success(coinDetail)
        } catch (e: Exception) {
            return Response.Error(e)
        }
    }
}