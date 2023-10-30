package ru.bardinpetr.itmo.web.lab4.points.model

import jakarta.persistence.*
import ru.bardinpetr.itmo.web.lab4.user.model.User
import java.time.Duration
import java.time.LocalDateTime

@Entity
@Table(name = "point_result")
data class PointResult(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne
    val owner: User,

    @Embedded
    val point: Point,

    @Embedded
    val area: AreaConfig,

    @Column(nullable = false)
    val inside: Boolean,

    @Column(nullable = false)
    val executionTime: Duration,

    @Column(nullable = false)
    val timestamp: LocalDateTime = LocalDateTime.now()
)
