package ru.bardinpetr.itmo.web.lab4.models

import jakarta.persistence.Embeddable

@Embeddable
data class Point(
    val x: Double = 0.0,
    val y: Double = 0.0
) {
    fun scale(factor: Double): Point {
        return Point(x * factor, y * factor)
    }
}



