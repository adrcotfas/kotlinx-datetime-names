package io.github.adrcotfas.datetime.names

import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toJavaLocalDate
import kotlinx.datetime.toJavaZoneId
import java.time.format.DateTimeFormatter

/**
 * JVM/Android implementation of LocalDate formatting using DateTimeFormatter.
 */
actual fun LocalDate.format(
    formatStyle: FormatStyle,
    locale: PlatformLocale,
    timeZone: TimeZone
): String {
    val javaFormatStyle =
        formatStyleMapping[formatStyle]
            ?: error("Unknown FormatStyle: $formatStyle")

    val formatter =
        DateTimeFormatter.ofLocalizedDate(javaFormatStyle)
            .withLocale(locale)
            .withZone(timeZone.toJavaZoneId())

    return this.toJavaLocalDate().format(formatter)
}
