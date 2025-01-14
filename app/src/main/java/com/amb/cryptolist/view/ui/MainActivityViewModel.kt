package com.amb.cryptolist.view.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amb.cryptolist.domain.usecase.GetCoinsUseCase

class MainActivityViewModel(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {


    companion object {
        val Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MainActivityViewModel(
                    getCoinsUseCase = GetCoinsUseCase()
                ) as T
            }
        }
    }
}