package com.bitcoins.bitcoin.feature.domain.model

import com.bitcoins.bitcoin.feature.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank : Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team : List<TeamMember>
)