package ru.bardinpetr.itmo.web.lab4.points.model

import jakarta.persistence.Embeddable
import jakarta.validation.constraints.Digits
import ru.bardinpetr.itmo.web.lab4.constraints.validator.range.InDoubleRange
import kotlin.math.abs

@Embeddable
data class AreaConfig(
    @InDoubleRange(rangeBean = "rRange")
    @Digits(integer = 6, fraction = 6)
    val r: Double = 1.0
) {

    companion object {
        var EPSILON = 1e-6
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || javaClass != other.javaClass) return false
        if (this === other) return true

        other as AreaConfig
        return abs(r - other.r) < EPSILON
    }

    override fun hashCode(): Int {
        return r.hashCode()
    }
}
