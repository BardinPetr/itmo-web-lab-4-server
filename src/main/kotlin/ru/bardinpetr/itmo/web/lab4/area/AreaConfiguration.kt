package ru.bardinpetr.itmo.web.lab4.area

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.bardinpetr.itmo.web.lab4.area.model.areas.AreaCircle
import ru.bardinpetr.itmo.web.lab4.area.model.areas.AreaPolygon
import ru.bardinpetr.itmo.web.lab4.area.model.areas.GenericArea
import ru.bardinpetr.itmo.web.lab4.points.model.Point
import kotlin.math.PI

@Configuration
class AreaConfiguration {

    @Bean
    fun areaPolygonDefinition(): GenericArea =
        GenericArea()
            .apply {
                append(polygonArea())
                append(arcArea())
            }

    protected fun polygonArea() = AreaPolygon(
        listOf(
            Point(0.0, 0.0),
            Point(0.0, -0.5),
            Point(1.0, -0.5),
            Point(1.0, 0.0),
            Point(0.0, 0.5),
        )
    )

    protected fun arcArea() =
        AreaCircle(
            Point(0.0, 0.0),
            radius = 0.5,
            angleStartRadians = PI / 2,
            angleEndRadians = PI
        )
}