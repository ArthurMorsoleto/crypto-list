package com.amb.cryptolist.view.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.amb.cryptolist.common.Response
import com.amb.cryptolist.domain.usecase.GetCoinsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CryptoCoinListViewModel(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private var _viewState = MutableStateFlow(ViewState())
    val viewState = _viewState.asStateFlow()

    init {
        getCoins()
    }

    private fun getCoins() {
        viewModelScope.launch {
            _viewState.update { it.copy(isLoading = true) }

            when (val response = getCoinsUseCase()) {
                is Response.Success -> {
                    _viewState.update {
                        it.copy(
                            coins = response.data ?: emptyList(), isLoading = false
                        )
                    }
                }

                is Response.Error -> {
                    _viewState.update {
                        it.copy(
                            error = response.error?.localizedMessage,
                            isLoading = false
                        )
                    }
                }
            }
        }
    }

    companion object {
        val Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return CryptoCoinListViewModel(
                    getCoinsUseCase = GetCoinsUseCase()
                ) as T
            }
        }
    }
}