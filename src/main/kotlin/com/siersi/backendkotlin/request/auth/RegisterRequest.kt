package com.siersi.backendkotlin.request.auth

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class RegisterRequest(
    @field:NotBlank(message = "账号不能为空")
    @field:Size(min = 4, max = 32, message = "账号长度必须在4-32个字符之间")
    val account: String,

    @field:NotBlank(message = "密码不能为空")
    @field:Size(min = 4, max = 32, message = "密码长度必须在4-32个字符之间")
    val password: String
)