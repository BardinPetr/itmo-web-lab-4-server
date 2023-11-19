package ru.bardinpetr.itmo.web.lab4.constraints.models

import jakarta.validation.constraints.NotNull

data class DoubleRange(
    val min: @NotNull Double,
    val minIsInclusive: Boolean = true,
    val max: @NotNull Double,
    val maxIsInclusive: Boolean = true,
) {

    override fun toString(): String {
        return "%s%.2f, %.2f%s".format(
            if (minIsInclusive) "[" else "(",
            min,
            max,
            if (maxIsInclusive) "]" else ")"
        )
    }
}