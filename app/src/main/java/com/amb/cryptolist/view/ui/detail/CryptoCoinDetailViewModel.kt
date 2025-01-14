package com.amb.cryptolist.view.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.amb.cryptolist.common.Response
import com.amb.cryptolist.domain.usecase.GetCoinDetailUseCase
import kotlinx.coroutines.launch

class CryptoCoinDetailViewModel(
    private val coinDetailUseCase: GetCoinDetailUseCase = GetCoinDetailUseCase()
) : ViewModel() {

    private var _state = MutableLiveData<DetailViewState>()
    val state: LiveData<DetailViewState> = _state

    fun onViewReady(coinId: String) {
        viewModelScope.launch {
            _state.value = DetailViewState(isLoading = true)

            when (val response = coinDetailUseCase.invoke(coinId)) {
                is Response.Error -> {
                    _state.value = DetailViewState(
                        isLoading = false,
                        error = response.error?.localizedMessage.toString()
                    )
                }

                is Response.Success -> {
                    _state.value = DetailViewState(isLoading = false, coinDetail = response.data)
                }
            }
        }
    }

    companion object {
        val Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return CryptoCoinDetailViewModel() as T
            }
        }
    }
}