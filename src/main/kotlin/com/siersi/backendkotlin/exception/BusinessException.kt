package com.siersi.backendkotlin.exception

//class BusinessException: RuntimeException {
//    val code: Int
//
//    constructor(code: Int, message: String) : super(message) {
//        this.code = code
//    }
//
//    constructor(message: String): this(500, message)
//}

open class BusinessException(
    message: String,
    val code: Int = 500
): RuntimeException(message)