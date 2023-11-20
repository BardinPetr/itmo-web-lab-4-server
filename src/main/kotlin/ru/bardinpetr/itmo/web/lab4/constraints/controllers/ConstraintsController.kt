package ru.bardinpetr.itmo.web.lab4.constraints.controllers

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.bardinpetr.itmo.web.lab4.constraints.ConstraintsConfiguration
import ru.bardinpetr.itmo.web.lab4.constraints.models.DoubleRange

@RestController
@RequestMapping("/api/constraints")
class ConstraintsController(
    private val conf: ConstraintsConfiguration
) {
    @GetMapping("/{type}")
    @Operation(
        summary = "Get input variables range constraints",
        parameters = [Parameter(
            name = "type",
            description = "Name of requested parameter range: point X/Y or area scale R",
            schema = Schema(
            type="string",
            allowableValues=["x","y","r"]
        ))]
    )
    fun getConstraint(@PathVariable type: String): ResponseEntity<DoubleRange> =
        ResponseEntity.ofNullable(
            when (type) {
                "x" -> conf.xRange
                "y" -> conf.yRange
                "r" -> conf.rRange
                else -> null
            }
        )
}


