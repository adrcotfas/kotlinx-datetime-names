package io.github.adrcotfas.datetime.names

import java.time.format.DateTimeFormatter
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toJavaLocalDate
import kotlinx.datetime.toJavaZoneId

/**
 * JVM/Android implementation of LocalDate formatting using DateTimeFormatter.
 */
actual fun LocalDate.format(
    formatStyle: FormatStyle,
    locale: PlatformLocale,
    timeZone: TimeZone,
): String {
    val formatter =
        DateTimeFormatter
            .ofLocalizedDate(formatStyle.toJavaFormatStyle())
            .withLocale(locale)
            .withZone(timeZone.toJavaZoneId())

    return this.toJavaLocalDate().format(formatter)
}
