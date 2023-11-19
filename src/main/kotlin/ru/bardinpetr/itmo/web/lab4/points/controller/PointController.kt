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

//    @GetMapping
//    @Secured("ROLE_read_points")
//    fun read(principal: Principal): Iterable<PointResultDTO> =
//        repo
//            .getAllByOwner(principal.name)
//            .map(::PointResultDTO)

    @GetMapping("/all")
    @Secured("ROLE_read_points_all")
    fun readAll(): Iterable<PointResultDTO> =
        repo
            .findAll()
            .map(::PointResultDTO)

    @GetMapping("/{id}")
    @Secured("ROLE_read_points")
    fun read(@PathVariable id: Long): PointResultDTO =
        repo
            .findById(id)
            .map(::PointResultDTO)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }

//    @DeleteMapping
//    @Secured("ROLE_manage_points")
//    fun delete(principal: Principal) =
//        repo.removeAllByOwner(principal.name)

    @PostMapping
    @Secured("ROLE_create_points")
    fun create(@RequestBody req: PointCheckDTO, principal: Principal): PointCheckResultDTO {
        try {
            return service.check(req)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        }
    }
}