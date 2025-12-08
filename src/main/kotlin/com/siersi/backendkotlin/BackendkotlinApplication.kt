package com.siersi.backendkotlin

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@MapperScan(basePackages = ["com.siersi.backendkotlin.mapper"])
class BackendkotlinApplication

fun main(args: Array<String>) {
    runApplication<BackendkotlinApplication>(*args)
}
