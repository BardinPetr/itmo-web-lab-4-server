package ru.bardinpetr.itmo.web.lab4.constraints.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.bardinpetr.itmo.web.lab4.constraints.models.DoubleRange

@RestController
@RequestMapping("/api/constraints")
class ConstraintsController(
    private val xRange: DoubleRange,
    private val yRange: DoubleRange,
    private val rRange: DoubleRange
) {

    @GetMapping("/x")
    fun getX() = xRange

    @GetMapping("/y")
    fun getY() = yRange

    @GetMapping("/r")
    fun getR() = rRange
}


