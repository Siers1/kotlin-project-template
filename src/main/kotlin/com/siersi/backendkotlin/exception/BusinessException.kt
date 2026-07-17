package com.siersi.backendkotlin.exception

open class BusinessException(
    message: String,
    val code: Int = 500
): RuntimeException(message)