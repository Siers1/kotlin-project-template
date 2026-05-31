package com.siersi.backendkotlin.exception

import com.siersi.backendkotlin.utils.Result
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.NoHandlerFoundException

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(e: BusinessException): Result<Unit> {
        return Result.failure(e.message ?: "系统错误", e.code)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleJsonParseError(e: HttpMessageNotReadableException): Result<Unit> {
        return Result.failure("参数格式错误", 400)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException): Result<Unit> {
        val errorMessage = e.bindingResult.allErrors
            .joinToString("; ") { it.defaultMessage ?: "参数验证错误" }
        return Result.failure(errorMessage, 400)
    }

    @ExceptionHandler(NoHandlerFoundException::class)
    fun handleNoHandlerFoundException(e: NoHandlerFoundException): Result<Unit> {
        return Result.failure("请求的接口不存在", 404)
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    fun handleHttpRequestMethodNotSupportedException(e: HttpRequestMethodNotSupportedException): Result<Unit> {
        return Result.failure("不支持的请求方法", 405)
    }

    @ExceptionHandler(Exception::class)
    fun handleRuntimeException(e: Exception): Result<Unit> {
        return Result.failure((e.javaClass.name + ": " + e.message), 500)
    }
}