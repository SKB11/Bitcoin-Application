package com.bitcoins.bitcoin.feature.domain.repository

import com.bitcoins.bitcoin.feature.data.remote.dto.CoinDetailDto
import com.bitcoins.bitcoin.feature.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId:String): CoinDetailDto

}