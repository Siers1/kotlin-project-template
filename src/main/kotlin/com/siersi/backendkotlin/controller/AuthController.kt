package com.siersi.backendkotlin.controller

import com.siersi.backendkotlin.request.auth.LoginRequest
import com.siersi.backendkotlin.request.auth.RegisterRequest
import com.siersi.backendkotlin.service.user.UserService
import com.siersi.backendkotlin.utils.Result
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val userService: UserService,
) {

    @PostMapping("/register")
    fun register(@RequestBody @Valid registerRequest: RegisterRequest): Result<Unit> {
        userService.register(registerRequest)
        return Result.success("注册成功")
    }

    @PostMapping("/login")
    fun login(@RequestBody @Valid loginRequest: LoginRequest): Result<String> {
        return Result.success("登录成功", userService.login(loginRequest))
    }
}