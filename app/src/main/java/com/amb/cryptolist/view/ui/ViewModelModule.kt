package com.amb.cryptolist.view.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore

object ViewModelModule {
    fun bindViewModel(store: ViewModelStore) =
        ViewModelProvider(store, MainActivityViewModel.Factory)[MainActivityViewModel::class.java]
}