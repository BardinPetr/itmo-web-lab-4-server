package ru.bardinpetr.itmo.web.lab4.points.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import ru.bardinpetr.itmo.web.lab4.points.dto.PointCheckDTO
import ru.bardinpetr.itmo.web.lab4.points.dto.PointCheckResultDTO
import ru.bardinpetr.itmo.web.lab4.points.dto.PointResultDTO
import ru.bardinpetr.itmo.web.lab4.points.repository.PointResultRepository
import ru.bardinpetr.itmo.web.lab4.points.service.PointCheckService

@RestController
@RequestMapping("/api/point")
class PointController(
    val repo: PointResultRepository,
    val service: PointCheckService,
) {

    @GetMapping
    fun read(): Iterable<PointResultDTO> =
        repo
            .findAll()
            .map(::PointResultDTO)

    @GetMapping("/{id}")
    fun read(@PathVariable id: Long): PointResultDTO =
        repo
            .findById(id)
            .map(::PointResultDTO)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }

    @PostMapping
    fun create(@RequestBody req: PointCheckDTO): PointCheckResultDTO {
        try {
            return service.check(req)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        }
    }
}