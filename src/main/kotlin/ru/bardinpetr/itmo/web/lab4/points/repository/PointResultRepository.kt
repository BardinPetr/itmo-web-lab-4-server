package ru.bardinpetr.itmo.web.lab4.points.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional
import ru.bardinpetr.itmo.web.lab4.points.model.PointResult
import ru.bardinpetr.itmo.web.lab4.user.model.User

interface PointResultRepository : CrudRepository<PointResult, Long> {

    fun getAllByOwner(owner: User): List<PointResult>

    @Transactional
    fun removeAllByOwner(owner: User)

    @Transactional
    fun removeByOwnerAndId(owner: User, id: Long)
}