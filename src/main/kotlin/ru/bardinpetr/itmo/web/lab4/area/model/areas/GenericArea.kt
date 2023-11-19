package ru.bardinpetr.itmo.web.lab4.area.model.areas

import ru.bardinpetr.itmo.web.lab4.area.model.Area
import ru.bardinpetr.itmo.web.lab4.points.model.Point

class GenericArea(
    val subareas: MutableList<Area> = mutableListOf()
) : Area {

    override fun isInside(pt: Point): Boolean =
        subareas
            .stream()
            .anyMatch { it.isInside(pt) }

    fun append(other: Area) {
        subareas.add(other)
    }
}