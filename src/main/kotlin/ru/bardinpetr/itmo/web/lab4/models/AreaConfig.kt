package ru.bardinpetr.itmo.web.lab4.models

import jakarta.persistence.Embeddable
import kotlin.math.abs

@Embeddable
data class AreaConfig(val r: Double = 1.0) {


    companion object {
        var EPSILON = 1e-6
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AreaConfig
        return abs(r - other.r) < EPSILON
    }

    override fun hashCode(): Int {
        return r.hashCode()
    }
}
