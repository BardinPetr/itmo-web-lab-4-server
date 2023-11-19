package ru.bardinpetr.itmo.web.lab4.points.model

import jakarta.persistence.Embeddable
import ru.bardinpetr.itmo.web.lab4.constraints.validator.range.InDoubleRange
import kotlin.math.atan2
import kotlin.math.hypot

@Embeddable
data class Point(
    @InDoubleRange(rangeBean = "xRange")
    val x: Double = 0.0,
    @InDoubleRange(rangeBean = "yRange")
    val y: Double = 0.0
) {
    fun scale(factor: Double) = Point(x * factor, y * factor)

    fun minus(other: Point) = Point(x - other.x, y - other.y)

    fun dist(other: Point): Double {
        val delta = minus(other)
        return hypot(delta.x, delta.y)
    }

    fun polar() = PolarPoint(dist(Point(0.0, 0.0)), atan2(y, x))
}



