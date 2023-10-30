package ru.bardinpetr.itmo.web.lab4.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional
import ru.bardinpetr.itmo.web.lab4.models.PointResult
import ru.bardinpetr.itmo.web.lab4.models.User

interface PointResultRepository : CrudRepository<PointResult, Long> {

    fun getAllByOwner(owner: User) : List<PointResult>

    @Transactional
    fun removeAllByOwner(owner: User)

}