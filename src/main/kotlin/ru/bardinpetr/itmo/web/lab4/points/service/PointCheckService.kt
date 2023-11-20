package ru.bardinpetr.itmo.web.lab4.points.service

import org.springframework.stereotype.Service
import ru.bardinpetr.itmo.web.lab4.area.service.AreaService
import ru.bardinpetr.itmo.web.lab4.points.dto.PointRequestDTO
import ru.bardinpetr.itmo.web.lab4.points.dto.PointResultDTO
import ru.bardinpetr.itmo.web.lab4.points.model.PointResult
import ru.bardinpetr.itmo.web.lab4.points.repository.PointResultRepository
import ru.bardinpetr.itmo.web.lab4.user.model.User
import ru.bardinpetr.itmo.web.lab4.user.repository.UserRepository
import java.time.Duration
import java.time.LocalDateTime

@Service
class PointCheckService(
    val repo: PointResultRepository,
    val userRepository: UserRepository,
    val areaService: AreaService
) {
    fun check(request: PointRequestDTO, principal: User): PointResultDTO {
        val start = LocalDateTime.now()
        val point = request.point
        val config = request.area

        val isInside = areaService.isInside(point, config)

        val res = repo.save(
            PointResult(
                owner = principal,
                area = config,
                point = point,
                executionTime = Duration.between(start, LocalDateTime.now()),
                inside = isInside
            )
        )

        return PointResultDTO(res)
    }
}
