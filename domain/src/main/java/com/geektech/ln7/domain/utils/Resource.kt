package com.geektech.ln7.domain.utils

sealed class Resource<T>(
    val  data:T?=null,
    val  massage:String?=null
) {
    class Loading<T> : Resource<T>()
    class Success<T>(data: T): Resource<T>(data=data)
    class Error<T>(massage: String,data: T?=null): Resource<T>(massage=massage, data = data)
}
