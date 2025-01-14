package com.amb.cryptolist.data.response

import com.amb.cryptolist.domain.model.CryptoCoin
import com.google.gson.annotations.SerializedName

data class CryptoCoinResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("type")
    val type: String
) {
    fun toCryptoCoin(): CryptoCoin {
        return CryptoCoin(
            id = id,
            name = name,
            symbol = symbol
        )
    }
}