package ru.bardinpetr.itmo.web.lab4.area.service

import org.springframework.stereotype.Service
import ru.bardinpetr.itmo.web.lab4.area.model.areas.GenericArea
import ru.bardinpetr.itmo.web.lab4.points.model.AreaConfig
import ru.bardinpetr.itmo.web.lab4.points.model.Point

@Service
class AreaService(
    val areaPolygonDefinition: GenericArea
) {

    fun isInside(point: Point, areaConfig: AreaConfig) =
        areaPolygonDefinition.isInside(
            point.scale(1 / areaConfig.r)
        )
}