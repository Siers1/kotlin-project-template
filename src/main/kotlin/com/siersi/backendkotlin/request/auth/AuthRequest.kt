package com.siersi.backendkotlin.request.auth

data class AuthRequest(
    val account: String,
    val password: String
)