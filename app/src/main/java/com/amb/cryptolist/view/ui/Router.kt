package com.amb.cryptolist.view.ui

import android.content.Context
import android.content.Intent
import com.amb.cryptolist.view.ui.detail.CryptoCoinDetailActivity
import com.amb.cryptolist.view.ui.detail.CryptoCoinDetailActivity.Companion.COIN_ID_KEY

object Router {
    fun openDetailScreen(context: Context, coinId: String) {
        val intent = Intent(context, CryptoCoinDetailActivity::class.java).apply {
            putExtra(COIN_ID_KEY, coinId)
        }
        context.startActivity(intent)
    }
}