package ru.bardinpetr.itmo.web.lab4.security

import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.oauth2.jwt.Jwt
import ru.bardinpetr.itmo.web.lab4.user.model.User

class UserAuthentication(
    private val user: User?,
    private val token: Jwt?,
    authorities: Collection<GrantedAuthority?>?
) : AbstractAuthenticationToken(authorities) {
    constructor() : this(null, null, null)


    init {
        isAuthenticated = credentials != null
    }

    override fun getCredentials() = token

    override fun getPrincipal() = user

    override fun getName() = token?.subject
}