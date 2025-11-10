package io.github.adrcotfas.datetime.names

import java.time.format.DateTimeFormatter
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toJavaLocalDateTime
import kotlinx.datetime.toJavaZoneId

/**
 * JVM/Android implementation of LocalDateTime formatting using DateTimeFormatter.
 */
@OptIn(kotlin.time.ExperimentalTime::class)
actual fun LocalDateTime.format(
    dateStyle: FormatStyle,
    timeStyle: FormatStyle,
    locale: PlatformLocale,
    timeZone: TimeZone,
): String {
    val javaDateStyle =
        formatStyleMapping[dateStyle]
            ?: error("Unknown FormatStyle: $dateStyle")
    val javaTimeStyle =
        formatStyleMapping[timeStyle]
            ?: error("Unknown FormatStyle: $timeStyle")

    return this.toJavaLocalDateTime().format(
        DateTimeFormatter
            .ofLocalizedDateTime(javaDateStyle, javaTimeStyle)
            .withLocale(locale)
            .withZone(timeZone.toJavaZoneId()),
    )
}
