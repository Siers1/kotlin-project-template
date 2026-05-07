package com.siersi.backendkotlin.request.auth

import jakarta.validation.constraints.NotBlank

data class LoginRequest (
    @field:NotBlank(message = "账号不能为空")
    val account: String,

    @field:NotBlank(message = "密码不能为空")
    val password: String
)