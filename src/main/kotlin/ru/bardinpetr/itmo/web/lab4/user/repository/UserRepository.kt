package ru.bardinpetr.itmo.web.lab4.user.repository

import org.springframework.data.repository.CrudRepository
import ru.bardinpetr.itmo.web.lab4.user.model.User
import java.util.*

interface UserRepository : CrudRepository<User, UUID> {
    fun getUserByLogin(login: String): User
}
