package moe.crx.roadblock.core.utils

import kotlinx.datetime.*

fun Instant.midnight(): Instant {
    val timeZone = TimeZone.currentSystemDefault()
    val localDateTime = toLocalDateTime(timeZone)
    val midnight = LocalTime(0, 0)
    val date = LocalDateTime(localDateTime.date, midnight)
    return date.toInstant(timeZone)
}
