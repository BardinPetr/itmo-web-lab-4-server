package ru.bardinpetr.itmo.web.lab4.user.repository

import org.springframework.data.repository.CrudRepository
import ru.bardinpetr.itmo.web.lab4.user.model.User

interface UserRepository : CrudRepository<User, Long> {
    fun getUserByLogin(login: String): User
}
