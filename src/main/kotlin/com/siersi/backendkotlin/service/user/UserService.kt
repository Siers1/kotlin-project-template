package com.siersi.backendkotlin.service.user

import com.mybatisflex.core.service.IService
import com.siersi.backendkotlin.entity.User
import com.siersi.backendkotlin.request.auth.LoginRequest
import com.siersi.backendkotlin.request.auth.RegisterRequest

interface UserService: IService<User> {
    fun register(registerRequest: RegisterRequest): Unit

    fun login(loginRequest: LoginRequest): String
}