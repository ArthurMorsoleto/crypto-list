package com.amb.cryptolist.view.ui

import com.amb.cryptolist.domain.model.CryptoCoin

data class ViewState(
    val isLoading: Boolean = true,
    val coins: List<CryptoCoin> = emptyList(),
    val error: String? = null
)