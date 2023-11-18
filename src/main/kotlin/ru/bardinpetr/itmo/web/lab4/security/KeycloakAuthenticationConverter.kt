package ru.bardinpetr.itmo.web.lab4.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter

@Configuration
class KeycloakAuthenticationConverter {

    @Bean
    fun jwtAuthenticationConverter() =
        JwtAuthenticationConverter().apply {
            setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter())
        }

    @Bean
    fun jwtGrantedAuthoritiesConverter(): Converter<Jwt, Collection<GrantedAuthority>> {
        val baseConverter = JwtGrantedAuthoritiesConverter()
        baseConverter.setAuthorityPrefix("ROLE_")

        return object : Converter<Jwt, Collection<GrantedAuthority>> {
            override fun convert(jwt: Jwt): Collection<GrantedAuthority> {
                val authorities =
                    baseConverter
                        .convert(jwt)
                        .orEmpty()
                        .toMutableList()

                jwt
                    .getClaimAsMap("realm_access")
                    ?.let {
                        val roles = it.getOrDefault("roles", emptyList<String>()) as List<*>
                        authorities.addAll(
                            roles
                                .stream()
                                .map { role -> SimpleGrantedAuthority("ROLE_$role") }
                                .toList()
                        )
                    }

                return authorities
            }
        }
    }
}