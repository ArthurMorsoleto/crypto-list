package com.amb.cryptolist.view.ui.list

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.amb.cryptolist.view.ui.Router
import com.amb.cryptolist.view.ui.ViewModelModule.bindViewModel
import com.amb.cryptolist.view.ui.components.CryptoCoinItem
import com.amb.cryptolist.view.ui.theme.CryptoListTheme

class CryptoCoinListActivity : ComponentActivity() {

    private val viewModel by lazy { bindViewModel(viewModelStore) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state by viewModel.viewState.collectAsState()
            CryptoListTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(state.coins) { coin ->
                            CryptoCoinItem(
                                coin = coin,
                                onItemClick = {
                                    Router.openDetailScreen(
                                        context = this@CryptoCoinListActivity,
                                        coinId = coin.id
                                    )
                                }
                            )
                        }
                    }
                    if (state.error?.isNotBlank() == true) {
                        Text(
                            text = state.error.toString(),
                            color = MaterialTheme.colorScheme.error,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
                                .align(Alignment.Center)
                        )
                    }
                    if (state.isLoading) {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }
                }
            }
        }
    }
}