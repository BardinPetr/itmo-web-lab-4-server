package ru.bardinpetr.itmo.web.lab4.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.Repository
import ru.bardinpetr.itmo.web.lab4.models.PointResult
import ru.bardinpetr.itmo.web.lab4.models.User

interface UserRepository : CrudRepository<User, Long> {
    fun getUserByLogin(login: String): User
}
