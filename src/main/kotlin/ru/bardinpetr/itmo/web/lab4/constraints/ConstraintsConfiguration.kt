package ru.bardinpetr.itmo.web.lab4.constraints

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import ru.bardinpetr.itmo.web.lab4.constraints.models.DoubleRange
import ru.bardinpetr.itmo.web.lab4.constraints.type.RangeConstraint.*
import ru.bardinpetr.itmo.web.lab4.constraints.type.RangeConstraintType

@ConfigurationProperties(prefix = "app.constraints")
class ConstraintsConfiguration(
    @get:Bean(name = ["xRange"]) @RangeConstraintType(X) val xRange: DoubleRange,
    @get:Bean(name = ["yRange"]) @RangeConstraintType(Y) val yRange: DoubleRange,
    @get:Bean(name = ["rRange"]) @RangeConstraintType(R) val rRange: DoubleRange,
)