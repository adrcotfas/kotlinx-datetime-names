package io.github.adrcotfas.datetime.names

import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toJavaLocalTime
import kotlinx.datetime.toJavaZoneId
import java.time.format.DateTimeFormatter

/**
 * JVM/Android implementation of LocalTime formatting using DateTimeFormatter.
 *
 */
@OptIn(kotlin.time.ExperimentalTime::class)
actual fun LocalTime.format(
    formatStyle: FormatStyle,
    locale: PlatformLocale,
    timeZone: TimeZone,
): String {
    val javaFormatStyle =
        formatStyleMapping[formatStyle]
            ?: error("Unknown FormatStyle: $formatStyle")

    return this.toJavaLocalTime().format(
        DateTimeFormatter.ofLocalizedTime(javaFormatStyle)
            .withLocale(locale)
            .withZone(timeZone.toJavaZoneId()),
    )
}
