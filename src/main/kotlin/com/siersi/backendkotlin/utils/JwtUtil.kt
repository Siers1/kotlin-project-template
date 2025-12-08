package com.siersi.backendkotlin.utils

import cn.hutool.core.date.DateUtil
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTVerificationException
import com.auth0.jwt.interfaces.DecodedJWT
import com.auth0.jwt.interfaces.JWTVerifier
import com.siersi.backendkotlin.exception.BusinessException
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtUtil {
    @Value("\${jwt.secret}")
    private var secret: String = ""

    @Value("\${jwt.expiration}")
    private var expiration: Int = 0

    fun generateToken(id: Long): String {
        return JWT.create()
            .withSubject(id.toString())
            .withExpiresAt(DateUtil.offsetDay(Date(), expiration))
            .sign(Algorithm.HMAC256(secret))
    }

    fun verifyToken(token: String): Boolean {
        try {
            val algorithm: Algorithm = Algorithm.HMAC256(secret)
            val verifier: JWTVerifier = JWT.require(algorithm).build()
            verifier.verify(token)
            return true
        } catch (_: JWTVerificationException) {
            return false
        }
    }

    fun getUserId(token: String): Long {
        val jwt: DecodedJWT = JWT.decode(token)
        return jwt.subject.toLong()
    }

    fun extractToken(authorization: String): String {
        if (authorization.startsWith("Bearer ")) return authorization.substring(7)

        throw BusinessException("请登录", 401)
    }
}