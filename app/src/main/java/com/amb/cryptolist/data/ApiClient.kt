package com.amb.cryptolist.data

import com.amb.network.Networking

object ApiClient {
    val service: Api by lazy { Networking.retrofit.create(Api::class.java) }
}