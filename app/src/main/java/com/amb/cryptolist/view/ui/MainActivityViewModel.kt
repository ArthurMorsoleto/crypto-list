package com.amb.cryptolist.view.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.amb.cryptolist.common.Response
import com.amb.cryptolist.domain.usecase.GetCoinsUseCase
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private var _state = mutableStateOf(ViewState())
    val state: State<ViewState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        viewModelScope.launch {
            _state.value = ViewState(isLoading = true)
            when (val response = getCoinsUseCase()) {
                is Response.Success -> {
                    _state.value = ViewState(
                        coins = response.data ?: emptyList(),
                        isLoading = false
                    )
                }

                is Response.Error -> {
                    _state.value = ViewState(error = response.error, isLoading = false)
                }
            }
        }
    }

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