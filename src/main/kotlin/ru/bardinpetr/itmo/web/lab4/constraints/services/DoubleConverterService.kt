package ru.bardinpetr.itmo.web.lab4.constraints.services

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import java.util.function.Predicate
import java.util.regex.Pattern

class DoubleConverterService(
    maxPrecision: Int
) : StdDeserializer<Double>(Double::class.java) {
    private val isNotDouble: Predicate<String> =
        Pattern
            .compile("^-?\\d+(\\.\\d{1,${maxPrecision}})?\$")
            .asPredicate()
            .negate()

    private fun convert(source: String?): Double? =
        if (source == null || isNotDouble.test(source)) null
        else source.toDoubleOrNull()

    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Double {
        val value = convert(p?.text)
        if (value == null) {
            ctxt?.handleWeirdNumberValue(Double::class.java, 0, "Invalid number")
            return 0.0
        }
        return value
    }
}