package com.amb.cryptolist.view.ui.detail

import com.amb.cryptolist.domain.model.CryptoCoinDetail

data class DetailViewState(
    val isLoading: Boolean = true,
    val coinDetail: CryptoCoinDetail? = null,
    val error: String = "",
)
