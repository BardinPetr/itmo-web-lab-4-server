package ru.bardinpetr.itmo.web.lab4.points.service

import org.springframework.stereotype.Service
import ru.bardinpetr.itmo.web.lab4.points.dto.PointCheckDTO
import ru.bardinpetr.itmo.web.lab4.points.dto.PointCheckResultDTO

@Service
class PointCheckService {
    fun check(request: PointCheckDTO): PointCheckResultDTO {
        return PointCheckResultDTO(1L, true)
    }
}
