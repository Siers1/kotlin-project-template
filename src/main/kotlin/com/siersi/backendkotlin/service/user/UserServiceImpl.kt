package com.siersi.backendkotlin.service.user

import com.mybatisflex.core.query.QueryWrapper
import com.mybatisflex.spring.service.impl.ServiceImpl
import com.siersi.backendkotlin.entity.User
import com.siersi.backendkotlin.exception.BusinessException
import com.siersi.backendkotlin.mapper.UserMapper
import com.siersi.backendkotlin.request.auth.AuthRequest
import org.springframework.stereotype.Service
import com.siersi.backendkotlin.entity.table.UserTableDef.USER;
import com.siersi.backendkotlin.utils.JwtUtil
import org.springframework.security.crypto.password.PasswordEncoder

@Service
class UserServiceImpl(
    private val userMapper: UserMapper,
    private val jwtUtil: JwtUtil,
    private val passwordEncoder: PasswordEncoder,
): ServiceImpl<UserMapper, User>(), UserService {

    override fun register(authRequest: AuthRequest): Unit {
        val queryWrapper = QueryWrapper.create()
            .select()
            .eq(User::account, authRequest.account)

        userMapper.selectOneByQuery(queryWrapper)?.let {
            throw BusinessException("用户已存在")
        }

        User(
            account = authRequest.account,
            password = passwordEncoder.encode(authRequest.password)
        ).also { userMapper.insertSelective(it) }
    }

    override fun login(authRequest: AuthRequest): String {
        val queryWrapper = QueryWrapper.create()
            .where(USER.ACCOUNT.eq(authRequest.account))

        val user: User = userMapper.selectOneByQuery(queryWrapper) ?: throw BusinessException("账号或密码错误")

        if (!passwordEncoder.matches(authRequest.password, user.password)) throw BusinessException("账号或密码错误")

        return jwtUtil.generateToken(user.id!!)
    }
}