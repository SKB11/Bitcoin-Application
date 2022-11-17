package com.bitcoins.bitcoin.feature.domain.use_cases.getCoins

import coil.network.HttpException
import com.bitcoins.bitcoin.common.Resource
import com.bitcoins.bitcoin.feature.data.remote.dto.toCoin
import com.bitcoins.bitcoin.feature.domain.model.Coin
import com.bitcoins.bitcoin.feature.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        }catch (e: HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error<List<Coin>>("Couldn't reach the server."))
        }
    }
}