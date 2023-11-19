package ru.bardinpetr.itmo.web.lab4.area.model.areas

import ru.bardinpetr.itmo.web.lab4.area.model.Area
import ru.bardinpetr.itmo.web.lab4.points.model.Point

data class AreaCircle(
    val center: Point,
    val radius: Double,
    val angleStartRadians: Double,
    val angleEndRadians: Double
) : Area {
    override fun isInside(pt: Point): Boolean {
        val angle = pt.minus(center).polar().phi
        return pt.dist(center) <= radius &&
                angleStartRadians <= angle &&
                angle <= angleEndRadians
    }
}