package ru.bardinpetr.itmo.web.lab4.user.model

import jakarta.persistence.*
import java.security.Principal

@Entity
@Table(name = "app_user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    val login: String,

    @Column(nullable = false)
    val passwordHash: String,

    @ManyToMany(cascade = [CascadeType.PERSIST], fetch = FetchType.EAGER)
    @JoinTable(name = "user_role")
    val roles: Set<Role> = mutableSetOf(),
) : Principal {

    override fun getName() = this.login
}
