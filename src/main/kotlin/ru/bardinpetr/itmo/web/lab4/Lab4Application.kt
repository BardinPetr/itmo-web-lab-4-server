package ru.bardinpetr.itmo.web.lab4

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication


@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan
class Lab4Application

fun main(args: Array<String>) {
    runApplication<Lab4Application>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}


