package com.amb.cryptolist.view.ui.list

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CryptoCoinListViewModelTest {

    @Before
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @Test
    fun `when screen is started then coins list should be initialized`() = runTest {
        CryptoCoinListViewModelRobot.apply {
            arrange {
                mockCoinList()
            }
            act {
                initCoinList()
            }
            assert {
                verifyCoinList()
            }
        }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        CryptoCoinListViewModelRobot.tearDown()
    }
}