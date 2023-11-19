package ru.bardinpetr.itmo.web.lab4.constraints.type

import org.springframework.beans.factory.annotation.Qualifier
import kotlin.annotation.AnnotationTarget.*

@Qualifier
@Target(FIELD, TYPE, FUNCTION, VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class RangeConstraintType(
    val value: RangeConstraint
)
