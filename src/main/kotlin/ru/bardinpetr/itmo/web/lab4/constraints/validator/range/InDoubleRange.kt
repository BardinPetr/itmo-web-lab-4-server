package ru.bardinpetr.itmo.web.lab4.constraints.validator.range

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass


@Target(AnnotationTarget.FIELD, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [DoubleRangeValidator::class])
annotation class InDoubleRange(
    val rangeBean: String,
    val message: String = "Out of range",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)