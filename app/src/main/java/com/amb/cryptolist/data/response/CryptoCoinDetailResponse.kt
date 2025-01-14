package com.amb.cryptolist.data.response

import com.amb.cryptolist.domain.model.CryptoCoinDetail
import com.google.gson.annotations.SerializedName

data class CryptoCoinDetailResponse(
    @SerializedName("description")
    val description: String,
    @SerializedName("development_status")
    val developmentStatus: String,
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("open_source")
    val openSource: Boolean,
    @SerializedName("org_structure")
    val orgStructure: String,
    @SerializedName("proof_type")
    val proofType: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("started_at")
    val startedAt: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("type")
    val type: String
) {
    fun toCoinDetail(): CryptoCoinDetail {
        return CryptoCoinDetail(
            title = name,
            symbol = symbol,
            description = description,
            image = logo
        )
    }
}