package ru.bardinpetr.itmo.web.lab4.security

import org.springframework.core.convert.converter.Converter
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import ru.bardinpetr.itmo.web.lab4.user.model.User
import ru.bardinpetr.itmo.web.lab4.user.repository.UserRepository
import java.util.*
import kotlin.jvm.optionals.getOrNull

@Component
class JwtUserAuthenticationConverter(
    private val delegate: JwtAuthenticationConverter,
    private val repo: UserRepository
) : Converter<Jwt, UserAuthentication> {
    override fun convert(source: Jwt): UserAuthentication? {
        val token = delegate.convert(source) ?: return null
        token as JwtAuthenticationToken

        if (!token.isAuthenticated)
            return UserAuthentication()

        val userId = UUID.fromString(token.name)

        val user: User? = try {
            repo.save(
                User(
                    id = userId,
                    login = ((token.principal as Jwt).claims["preferred_username"] ?: token.name) as String
                )
            )
        } catch (ex: DataIntegrityViolationException) {
            repo.findById(userId).getOrNull()
        }

        return UserAuthentication(
            user,
            token.token,
            token.authorities
        )
    }
}