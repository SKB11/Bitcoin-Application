package com.bitcoins.bitcoin.feature.presentation.coin_list

import com.bitcoins.bitcoin.feature.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)