package ru.bardinpetr.itmo.web.lab4.area.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.bardinpetr.itmo.web.lab4.area.model.Area

@RestController
@RequestMapping("/api/area")
class AreaController(
    val areaPolygonDefinition: Area
) {

    @GetMapping
    fun area(): Area = areaPolygonDefinition
}