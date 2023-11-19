package ru.bardinpetr.itmo.web.lab4.constraints

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import ru.bardinpetr.itmo.web.lab4.constraints.services.DoubleConverterService


@Configuration
class ConversionConfiguration {

    @Bean
    fun jackson2ObjectMapperBuilder(): Jackson2ObjectMapperBuilder {
        return Jackson2ObjectMapperBuilder()
            .deserializers(doubleConverterService())
    }

    @Bean
    fun doubleConverterService() = DoubleConverterService(6)
}