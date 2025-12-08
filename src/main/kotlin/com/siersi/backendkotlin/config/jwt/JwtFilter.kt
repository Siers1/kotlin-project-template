package com.siersi.backendkotlin.config.jwt

import com.siersi.backendkotlin.utils.JwtUtil
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtFilter(
    private val jwtUtil: JwtUtil
): OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authHeader: String? = request.getHeader("Authorization")

        authHeader?.let { header ->
            if (header.startsWith("Bearer ")) {
                try {
                    val token = header.substring(7)
                    if (jwtUtil.verifyToken(token)) {
                        val authentication = UsernamePasswordAuthenticationToken(jwtUtil.getUserId(token), null, emptyList())
                        authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
                        SecurityContextHolder.getContext().authentication = authentication
                    }
                } catch (_: Exception) {
                    // 忽略认证错误，继续过滤器链
                }
            }
        }

        filterChain.doFilter(request, response)
    }
}