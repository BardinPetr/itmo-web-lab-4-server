package ru.bardinpetr.itmo.web.lab4.points.service

import org.springframework.stereotype.Service
import ru.bardinpetr.itmo.web.lab4.area.service.AreaService
import ru.bardinpetr.itmo.web.lab4.points.dto.PointCheckDTO
import ru.bardinpetr.itmo.web.lab4.points.dto.PointCheckResultDTO
import ru.bardinpetr.itmo.web.lab4.points.model.PointResult
import ru.bardinpetr.itmo.web.lab4.points.repository.PointResultRepository
import ru.bardinpetr.itmo.web.lab4.user.repository.UserRepository
import java.time.Duration
import java.time.Instant
import java.util.*

@Service
class PointCheckService(
    val repo: PointResultRepository,
    val userRepository: UserRepository,
    val areaService: AreaService
) {
    fun check(request: PointCheckDTO): PointCheckResultDTO {
        val user = userRepository.findById(UUID.randomUUID()).get()

        val point = request.point
        val config = request.area

        val isInside = areaService.isInside(point, config)

        val saved = repo.save(
            PointResult(
                owner = user,
                area = config,
                point = point,
                executionTime = Duration.between(request.timestamp, Instant.now()),
                inside = isInside
            )
        )
        return PointCheckResultDTO(saved.id!!, isInside)
    }
}
