package io.github.adrcotfas.datetime.names

import java.time.format.DateTimeFormatter
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toJavaLocalTime
import kotlinx.datetime.toJavaZoneId

/**
 * JVM/Android implementation of LocalTime formatting using DateTimeFormatter.
 *
 */
@OptIn(kotlin.time.ExperimentalTime::class)
actual fun LocalTime.format(
    formatStyle: FormatStyle,
    locale: PlatformLocale,
    timeZone: TimeZone,
): String =
    this.toJavaLocalTime().format(
        DateTimeFormatter
            .ofLocalizedTime(formatStyle.toJavaFormatStyle())
            .withLocale(locale)
            .withZone(timeZone.toJavaZoneId()),
    )
