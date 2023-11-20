package ru.bardinpetr.itmo.web.lab4.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.AntPathRequestMatcher


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
    prePostEnabled = true,
    securedEnabled = true,
    jsr250Enabled = true
)
class SecurityConfig(
    private val jwtUserAuthenticationConverter: JwtUserAuthenticationConverter
) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .sessionManagement {
                it.disable()
            }
            .cors {
                it.disable()
            }
            .oauth2ResourceServer { rs ->
                rs.jwt {
                    it.jwtAuthenticationConverter(jwtUserAuthenticationConverter)
                }
            }
            .authorizeHttpRequests {
                it
                    .requestMatchers(
                        AntPathRequestMatcher("/docs"),
                        AntPathRequestMatcher("/docs/*"),
                        AntPathRequestMatcher("/swagger-ui/*")
                    ).permitAll()
                    .anyRequest().authenticated()
            }
            .build()
    }
}