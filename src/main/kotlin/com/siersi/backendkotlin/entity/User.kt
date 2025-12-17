package com.siersi.backendkotlin.entity

import com.mybatisflex.annotation.Id
import com.mybatisflex.annotation.KeyType
import com.mybatisflex.annotation.Table
import java.time.LocalDateTime

@Table("user")
data class User(

    @Id(keyType = KeyType.Auto)
    val id: Long = 0,

    val account: String,
    val password: String,
    val username: String? = null,
    val avatar: String? = null,
    val createTime: LocalDateTime? = null,
    val updateTime: LocalDateTime? = null,
    val valid: Int? = null
)