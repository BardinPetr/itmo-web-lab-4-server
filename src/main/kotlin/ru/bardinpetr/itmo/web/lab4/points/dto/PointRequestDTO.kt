package ru.bardinpetr.itmo.web.lab4.points.dto

import jakarta.validation.Valid
import ru.bardinpetr.itmo.web.lab4.points.model.AreaConfig
import ru.bardinpetr.itmo.web.lab4.points.model.Point
import java.time.LocalDateTime

data class PointRequestDTO(
    @field:Valid val point: Point,
    @field:Valid val area: AreaConfig,
)
