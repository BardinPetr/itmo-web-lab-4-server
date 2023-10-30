package ru.bardinpetr.itmo.web.lab4

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import ru.bardinpetr.itmo.web.lab4.models.AreaConfig
import ru.bardinpetr.itmo.web.lab4.models.Point
import ru.bardinpetr.itmo.web.lab4.models.PointResult
import ru.bardinpetr.itmo.web.lab4.models.User
import ru.bardinpetr.itmo.web.lab4.repository.PointResultRepository
import ru.bardinpetr.itmo.web.lab4.repository.UserRepository
import java.time.Duration

@Component
@Order(1)
class TestApp @Autowired constructor(
    private val user: UserRepository,
    private val point: PointResultRepository
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val usera = User(login = "a", passwordHash = "a")
        val userb = User(login = "b", passwordHash = "b")
        user.saveAll(listOf(usera, userb))

//        print(user.getUserByLogin("a"))
//        print(user.findAll())
//        print(user.findAll().map { it.roles })

        point.saveAll(listOf(
            PointResult(
                owner = usera,
                point = Point(1.1, 1.2),
                area = AreaConfig(1.0),
                isInside = true,
                executionTime = Duration.ofSeconds(1)
            )
        ))

        point.saveAll(listOf(
            PointResult(
                owner = usera,
                point = Point(2.1, 2.2),
                area = AreaConfig(2.0),
                isInside = false,
                executionTime = Duration.ofSeconds(2)
            )
        ))

        print(point.getAllByOwner(usera))
        point.removeAllByOwner(usera)
        point.removeAllByOwner(userb)
        print(point.findAll())

//        point.save()
    }
}