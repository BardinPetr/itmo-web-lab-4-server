package ru.bardinpetr.itmo.web.lab4.constraints

import org.springframework.context.annotation.Configuration
import org.springframework.format.FormatterRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import ru.bardinpetr.itmo.web.lab4.constraints.services.DoubleConverterService

@Configuration
class ConversionConfiguration: WebMvcConfigurer {
    override fun addFormatters(registry: FormatterRegistry) {
        registry.addConverter(DoubleConverterService())
    }
}