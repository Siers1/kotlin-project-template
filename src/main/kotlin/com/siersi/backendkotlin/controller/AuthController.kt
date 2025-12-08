package com.siersi.backendkotlin.controller

import com.siersi.backendkotlin.request.auth.AuthRequest
import com.siersi.backendkotlin.service.user.UserService
import com.siersi.backendkotlin.utils.Result
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
    private val userService: UserService,
) {

    @PostMapping("/register")
    fun register(@RequestBody authRequest: AuthRequest): Result<Unit> {
        userService.register(authRequest)
        return Result.success("注册成功")
    }

    @PostMapping("/login")
    fun login(@RequestBody authRequest: AuthRequest): Result<String> {
        return Result.success("登录成功", userService.login(authRequest))
    }
}