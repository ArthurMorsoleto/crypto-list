package com.amb.cryptolist.view.ui.detail

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.amb.cryptolist.R
import com.amb.cryptolist.domain.model.CryptoCoinDetail
import com.amb.cryptolist.view.ui.ViewModelModule.bindDetailViewModel
import com.bumptech.glide.Glide

class CryptoCoinDetailActivity : AppCompatActivity() {

    private val viewModel by lazy { bindDetailViewModel(viewModelStore) }

    private var title: TextView? = null
    private var symbol: TextView? = null
    private var description: TextView? = null
    private var logo: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_crypto_coin_detail)

        initViews()
        observeViewState()

        val coinId = intent.extras?.getString(COIN_ID_KEY)
        if (coinId.isNullOrEmpty()) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.onViewReady(coinId)
        }
    }

    private fun observeViewState() {
        viewModel.state.observe(this) { state ->
            if (state.isLoading) {
                print("show loading")
            }
            if (state.error.isNotBlank()) {
                Toast.makeText(this, state.error, Toast.LENGTH_SHORT).show()
            }
            if (state.coinDetail != null) {
                updateView(state.coinDetail)
            }
        }
    }

    private fun updateView(coinDetail: CryptoCoinDetail) {
        logo?.let { Glide.with(this).load(coinDetail.image).into(it) }
        title?.text = coinDetail.title
        description?.text = coinDetail.description
        symbol?.text = coinDetail.symbol
    }

    private fun initViews() {
        logo = findViewById(R.id.iv_logo)
        title = findViewById(R.id.tv_title)
        symbol = findViewById(R.id.tv_symbol)
        description = findViewById(R.id.tv_desc)
    }

    companion object {
        const val COIN_ID_KEY = "coinIdKey"
    }
}