package ru.bardinpetr.itmo.web.lab4.points.dto

import ru.bardinpetr.itmo.web.lab4.points.model.AreaConfig
import ru.bardinpetr.itmo.web.lab4.points.model.Point
import java.time.LocalDateTime

data class PointCheckDTO(
    val point: Point,
    val area: AreaConfig,
    val timestamp: LocalDateTime = LocalDateTime.now()
)
