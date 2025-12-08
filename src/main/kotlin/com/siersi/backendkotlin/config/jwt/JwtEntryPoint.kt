package com.siersi.backendkotlin.config.jwt

import com.fasterxml.jackson.databind.ObjectMapper
import com.siersi.backendkotlin.utils.Result
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component

@Component
class JwtEntryPoint(
    private val objectMapper: ObjectMapper
): AuthenticationEntryPoint {

    override fun commence(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authException: AuthenticationException
    ) {
        response.status = HttpServletResponse.SC_OK
        response.contentType = "application/json;charset=UTF-8"

        val result: Result<Unit> = Result.failure("请登录", 401)
        response.writer.write(objectMapper.writeValueAsString(result))
    }
}