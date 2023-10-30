package ru.bardinpetr.itmo.web.lab4.utils

import java.util.*

class KtExtensions {
    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}
