package com.amb.cryptolist.view.ui.list

import androidx.lifecycle.viewModelScope
import com.amb.cryptolist.common.Response
import com.amb.cryptolist.domain.model.CryptoCoin
import com.amb.cryptolist.domain.usecase.GetCoinsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.unmockkAll
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.launch

object CryptoCoinListViewModelRobot {

    private lateinit var subject: CryptoCoinListViewModel
    private var getCoinsUseCase = mockk<GetCoinsUseCase>()

    private val fakeCoinList = listOf(
        CryptoCoin(
            id = "id1",
            name = "name1",
            symbol = "symbol1"
        ),
        CryptoCoin(
            id = "id2",
            name = "name2",
            symbol = "symbol2"
        )
    )

    infix fun arrange(f: Arrange.() -> Unit) = Arrange().apply(f)
    infix fun act(f: Act.() -> Unit) = Act().apply(f)
    infix fun assert(f: Assert.() -> Unit) = Assert().apply(f)

    class Arrange {
        fun mockCoinList() {
            coEvery { getCoinsUseCase() } returns Response.Success(fakeCoinList)
        }

    }

    class Act {
        fun initCoinList() {
            subject = CryptoCoinListViewModel(getCoinsUseCase)
        }
    }

    class Assert {
        fun verifyCoinList() {
            subject.viewModelScope.launch {
                subject.viewState.collect {
                    assertEquals(2, it.coins.size)
                }
            }
        }
    }

    fun tearDown() {
        unmockkAll()
    }
}