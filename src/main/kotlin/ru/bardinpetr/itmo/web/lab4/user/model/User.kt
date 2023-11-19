package ru.bardinpetr.itmo.web.lab4.user.model

import jakarta.persistence.*
import java.security.Principal
import java.util.*

@Entity
@Table(name = "app_user")
data class User(
    @Id
    var id: UUID? = null,

    @Column(nullable = false, unique = true)
    val login: String,
)
