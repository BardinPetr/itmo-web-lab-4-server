package ru.bardinpetr.itmo.web.lab4.utils

import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class ModelMapperConfiguration {
    @Bean
    fun modelMapper() = ModelMapper()
}
