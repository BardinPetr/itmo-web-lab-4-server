package ru.bardinpetr.itmo.web.lab4.points.dto

import ru.bardinpetr.itmo.web.lab4.points.model.PointResult
import java.time.ZoneId

data class PointResultDTO(
    var id: Long,
    val owner: String,
    val areaR: Double,
    val pointX: Double,
    val pointY: Double,
    val inside: Boolean,
    val executionTimeNs: Long,
    val timestamp: Long
) {
    constructor(source: PointResult) : this(
        id = source.id!!,
        owner = source.owner.login,
        areaR = source.area.r,
        pointX = source.point.x,
        pointY = source.point.y,
        inside = source.inside,
        executionTimeNs = source.executionTime.toNanos(),
        timestamp = source.timestamp.atZone(ZoneId.systemDefault()).toEpochSecond()
    )
}