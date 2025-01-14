package com.amb.cryptolist.view.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.amb.cryptolist.view.ui.detail.CryptoCoinDetailViewModel
import com.amb.cryptolist.view.ui.list.CryptoCoinListViewModel

object ViewModelModule {
    fun bindViewModel(store: ViewModelStore) =
        ViewModelProvider(
            store,
            CryptoCoinListViewModel.Factory
        )[CryptoCoinListViewModel::class.java]

    fun bindDetailViewModel(store: ViewModelStore) =
        ViewModelProvider(
            store,
            CryptoCoinDetailViewModel.Factory
        )[CryptoCoinDetailViewModel::class.java]
}