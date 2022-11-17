package com.bitcoins.bitcoin.feature.presentation.coin_detail

import com.bitcoins.bitcoin.feature.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)