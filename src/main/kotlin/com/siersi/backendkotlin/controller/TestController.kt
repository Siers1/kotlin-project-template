package com.siersi.backendkotlin.controller

import com.siersi.backendkotlin.utils.Result
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestController {

    @GetMapping("/api1")
    fun test(): Result<Unit> {
        return Result.success("请求成功")
    }
}