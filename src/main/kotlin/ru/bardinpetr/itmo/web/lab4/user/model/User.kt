package ru.bardinpetr.itmo.web.lab4.user.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "app_user")
data class User(
    @Id
    var id: UUID? = null,

    @Column(nullable = false, unique = true)
    val login: String,
)
