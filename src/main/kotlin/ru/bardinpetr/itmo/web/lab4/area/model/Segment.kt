package ru.bardinpetr.itmo.web.lab4.area.model

import ru.bardinpetr.itmo.web.lab4.points.model.Point

data class Segment(
    val a: Point,
    val b: Point
) {
    fun directedArea(c: Point) =
        (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x)
}
