package com.siersi.backendkotlin.service.user

import com.mybatisflex.core.service.IService
import com.siersi.backendkotlin.entity.User
import com.siersi.backendkotlin.request.auth.AuthRequest

interface UserService: IService<User> {
    fun register(authRequest: AuthRequest): Unit

    fun login(authRequest: AuthRequest): String
}