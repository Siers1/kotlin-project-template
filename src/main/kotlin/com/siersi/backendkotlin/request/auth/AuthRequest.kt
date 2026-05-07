package com.siersi.backendkotlin.request.auth

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

interface RegisterGroup
interface LoginGroup

data class AuthRequest(
    @field:NotBlank(message = "账号不能为空", groups = [RegisterGroup::class, LoginGroup::class])
    @field:Size(min = 4, max = 32, message = "账号长度必须在4-20个字符之间", groups = [RegisterGroup::class, LoginGroup::class])
    val account: String,

    @field:NotBlank(message = "密码不能为空", groups = [RegisterGroup::class, LoginGroup::class])
    @field:Size(min = 4, max = 32, message = "密码长度必须在4-20个字符之间", groups = [RegisterGroup::class])
    val password: String
)