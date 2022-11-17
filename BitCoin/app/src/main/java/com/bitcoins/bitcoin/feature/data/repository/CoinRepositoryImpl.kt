package com.bitcoins.bitcoin.feature.data.repository

import com.bitcoins.bitcoin.feature.data.remote.CoinPaprikaApi
import com.bitcoins.bitcoin.feature.data.remote.dto.CoinDetailDto
import com.bitcoins.bitcoin.feature.data.remote.dto.CoinDto
import com.bitcoins.bitcoin.feature.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}