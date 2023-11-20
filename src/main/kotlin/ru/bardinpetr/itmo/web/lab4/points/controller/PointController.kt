package ru.bardinpetr.itmo.web.lab4.points.controller

import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.HttpStatus
import org.springframework.security.access.annotation.Secured
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import ru.bardinpetr.itmo.web.lab4.points.dto.PointCheckDTO
import ru.bardinpetr.itmo.web.lab4.points.dto.PointCheckResultDTO
import ru.bardinpetr.itmo.web.lab4.points.dto.PointResultDTO
import ru.bardinpetr.itmo.web.lab4.points.repository.PointResultRepository
import ru.bardinpetr.itmo.web.lab4.points.service.PointCheckService
import ru.bardinpetr.itmo.web.lab4.security.UserAuthentication

@RestController
@RequestMapping("/api/point")
class PointController(
    val repo: PointResultRepository,
    val service: PointCheckService,
) {

    @GetMapping
    @Secured("ROLE_read_points")
    @Operation(summary = "Get point check results of current user")
    fun read(auth: UserAuthentication): Iterable<PointResultDTO> =
        repo
            .getAllByOwner(auth.principal!!)
            .map(::PointResultDTO)

    @GetMapping("/all")
    @Secured("ROLE_read_points_all")
    @Operation(summary = "Get all point check results")
    fun readAll(): Iterable<PointResultDTO> =
        repo
            .findAll()
            .map(::PointResultDTO)

    @GetMapping("/{id}")
    @Secured("ROLE_read_points")
    @Operation(summary = "Get point result by id")
    fun read(@PathVariable id: Long, auth: UserAuthentication): PointResultDTO =
        repo
            .findById(id)
            .filter { it.owner.id!! == auth.principal!!.id }
            .map(::PointResultDTO)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }

    @DeleteMapping
    @Secured("ROLE_manage_points")
    fun delete(auth: UserAuthentication) =
        repo.removeAllByOwner(auth.principal!!)

    @PostMapping
    @Secured("ROLE_create_points")
    @Operation(summary = "Check if specified point in polygon scaled by r parameter")
    fun create(@RequestBody @Validated req: PointCheckDTO, auth: UserAuthentication): PointCheckResultDTO {
        try {
            return service.check(req, auth.principal!!)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        }
    }
}