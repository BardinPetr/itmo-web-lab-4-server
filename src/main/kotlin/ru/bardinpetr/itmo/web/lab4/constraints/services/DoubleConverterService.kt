package ru.bardinpetr.itmo.web.lab4.constraints.services

import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component
import java.util.function.Predicate
import java.util.regex.Pattern

@Component
class DoubleConverterService : Converter<String, Double> {

    override fun convert(source: String): Double? =
        if (isNotDouble.test(source)) null
        else source.toDoubleOrNull()

    companion object {
        val isNotDouble: Predicate<String> =
            Pattern
                .compile("^-?\\d+(\\.\\d{1,6})?\$")
                .asPredicate()
                .negate()
    }
}