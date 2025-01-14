package com.amb.cryptolist.common

sealed class Response<T>(val data: T? = null, val error: Exception? = null) {
    class Success<T>(data: T) : Response<T>(data = data)
    class Error<T>(e: Exception) : Response<T>(error = e)
}