package ru.bardinpetr.itmo.web.lab4.utils

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.security.SecurityScheme
import io.swagger.v3.oas.annotations.servers.Server
import org.springframework.context.annotation.Configuration

@Configuration
@OpenAPIDefinition(
    info = Info(
        title = "ITMO Lab4 API",
        version = "v1.1"
    ),
    servers = [Server(
        url = "http://weblab4.bardinpetr.ru"
    )]
)
@SecurityScheme(
    name = "bearerAuthentication",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    scheme = "bearer"
)
class OpenAPIConfiguration