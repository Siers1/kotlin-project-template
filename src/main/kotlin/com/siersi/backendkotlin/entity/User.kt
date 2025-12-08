package com.siersi.backendkotlin.entity

import com.mybatisflex.annotation.Table
import java.time.LocalDateTime

@Table("user")
data class User(
    val id: Long? = null,
    val account: String,
    val password: String,
    val username: String? = null,
    val avatar: String? = null,
    val createTime: LocalDateTime? = null,
    val updateTime: LocalDateTime? = null,
    val valid: Int? = null
)