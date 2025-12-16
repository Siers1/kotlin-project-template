package com.siersi.backendkotlin.controller

import com.mybatisflex.core.query.QueryWrapper
import com.siersi.backendkotlin.entity.User
import com.siersi.backendkotlin.mapper.UserMapper
import com.siersi.backendkotlin.utils.Result
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestController(
    private val userMapper: UserMapper
) {

    @GetMapping("/api")
    fun test(): Result<List<User>> {
        val users = userMapper.selectAll()

        return Result.success(users)
    }
}