package ru.bardinpetr.itmo.web.lab4

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.Banner
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import ru.bardinpetr.itmo.web.lab4.repository.PointResultRepository
import ru.bardinpetr.itmo.web.lab4.repository.UserRepository


@SpringBootApplication
class Lab4Application

fun main(args: Array<String>) {
    runApplication<Lab4Application>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}


