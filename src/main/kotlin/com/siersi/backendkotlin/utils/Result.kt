package com.siersi.backendkotlin.utils

@ConsistentCopyVisibility
data class Result<T> private constructor (
    val code: Int,
    val message: String,
    val data: T? = null
) {
    companion object {
        fun <T> success(): Result<T> = Result(200, "请求成功", null)

        fun success(message: String): Result<Unit> = Result(200, message, null)

        fun <T> success(data: T?): Result<T> = Result(200, "请求成功", data)

        fun <T> success(message:String, data: T): Result<T> = Result(200, message, data)

        fun failure(message: String): Result<Unit> = Result(500, message, null)

        fun failure(message: String, code:Int): Result<Unit> = Result(code, message, null)
    }
}