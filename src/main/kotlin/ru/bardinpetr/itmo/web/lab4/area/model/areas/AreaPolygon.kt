package ru.bardinpetr.itmo.web.lab4.area.model.areas

import ru.bardinpetr.itmo.web.lab4.area.model.Area
import ru.bardinpetr.itmo.web.lab4.area.model.Segment
import ru.bardinpetr.itmo.web.lab4.points.model.Point
import java.util.stream.IntStream

data class AreaPolygon(
    val points: List<Point>
) : Area {
    override fun isInside(pt: Point) =
        IntStream
            .range(0, points.size)
            .mapToObj { Segment(points[it], points[(it + 1) % points.size]) }
            .map { it.directedArea(pt) >= 0 }
            .allMatch { it }
}