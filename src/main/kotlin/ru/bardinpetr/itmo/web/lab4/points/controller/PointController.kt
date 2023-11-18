package ru.bardinpetr.itmo.web.lab4.points.controller

import org.springframework.http.HttpStatus
import org.springframework.security.access.annotation.Secured
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import ru.bardinpetr.itmo.web.lab4.points.dto.PointCheckDTO
import ru.bardinpetr.itmo.web.lab4.points.dto.PointCheckResultDTO
import ru.bardinpetr.itmo.web.lab4.points.dto.PointResultDTO
import ru.bardinpetr.itmo.web.lab4.points.repository.PointResultRepository
import ru.bardinpetr.itmo.web.lab4.points.service.PointCheckService
import java.security.Principal

@RestController
@RequestMapping("/api/point")
class PointController(
    val repo: PointResultRepository,
    val service: PointCheckService,
) {

    @GetMapping("/t1")
    fun t1() = "all"

    @GetMapping("/t2")
    @Secured("ROLE_read_points_all")
    fun t2() = "read_points_all"

    @GetMapping("/t3")
    @Secured("ROLE_manage_points")
    fun t3() = "manage_points"

    @GetMapping("/t4")
    @Secured("ROLE_create_points")
    fun t4() = "create_points"

    @GetMapping("/t5")
    @Secured("ROLE_read_points")
    fun t5() = "read_points"

    @GetMapping("/t6")
    fun t6(principal: Principal, authentication: Authentication): String {
        return SecurityContextHolder.getContext().authentication.authorities.toString()
    }

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