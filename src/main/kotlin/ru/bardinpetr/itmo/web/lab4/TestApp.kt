package ru.bardinpetr.itmo.web.lab4

import org.springframework.boot.CommandLineRunner
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
@Order(1)
class TestApp : CommandLineRunner {

    override fun run(vararg args: String?) {
//        val a = AreaPolygon(
//            listOf(
//                Point(0.0, 0.0),
//                Point(0.0, -0.5),
//                Point(1.0, -0.5),
//                Point(1.0, 0.0),
//                Point(0.0, 0.5),
//            )
//        )
//        println(a.isInside(Point(0.0, 0.3)))
//        println(a.isInside(Point(0.5, 0.2)))
//        println(a.isInside(Point(0.4, -0.3)))
//        println(a.isInside(Point(-0.3, 0.4)))
//        println(a.isInside(Point(1.2, -0.3)))
//        println(a.isInside(Point(0.0, 1.0)))
//        println(a.isInside(Point(0.5, -0.6)))

//        val a = AreaCircle(
//            Point(0.0, 0.0),
//            radius = 0.5,
//            angleStartRadians = PI / 2,
//            angleEndRadians = PI
//        )
//        println(a.isInside(Point(0.0, 0.2)))
//        println(a.isInside(Point(-0.2, 0.0)))
//        println(a.isInside(Point(-0.1, 0.28)))
//        println(a.isInside(Point(-0.5, 0.3)))

    }
}