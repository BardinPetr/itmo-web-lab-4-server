package ru.bardinpetr.itmo.web.lab4.area.model

import com.fasterxml.jackson.annotation.JsonTypeInfo
import io.swagger.v3.oas.annotations.media.DiscriminatorMapping
import io.swagger.v3.oas.annotations.media.Schema
import ru.bardinpetr.itmo.web.lab4.area.model.areas.AreaCircle
import ru.bardinpetr.itmo.web.lab4.area.model.areas.AreaPolygon
import ru.bardinpetr.itmo.web.lab4.area.model.areas.GenericArea
import ru.bardinpetr.itmo.web.lab4.points.model.Point

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type"
)
@Schema(
    title = "Area",
    subTypes = [
        GenericArea::class,
        AreaPolygon::class,
        AreaCircle::class
    ],
    discriminatorMapping = [
        DiscriminatorMapping(value = "GenericArea", schema = GenericArea::class),
        DiscriminatorMapping(value = "AreaPolygon", schema = AreaPolygon::class),
        DiscriminatorMapping(value = "AreaCircle", schema = AreaCircle::class)
    ],
    discriminatorProperty = "type"
)
interface Area {
    fun isInside(pt: Point): Boolean
}