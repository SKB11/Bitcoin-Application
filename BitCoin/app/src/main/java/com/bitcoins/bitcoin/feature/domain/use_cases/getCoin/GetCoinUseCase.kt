package com.bitcoins.bitcoin.feature.domain.use_cases.getCoin

import com.bitcoins.bitcoin.common.Resource
import com.bitcoins.bitcoin.feature.data.remote.dto.toCoinDetail
import com.bitcoins.bitcoin.feature.domain.model.CoinDetail
import com.bitcoins.bitcoin.feature.domain.repository.CoinRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        }catch (e: HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error<CoinDetail>("Couldn't reach the server."))
        }
    }
}