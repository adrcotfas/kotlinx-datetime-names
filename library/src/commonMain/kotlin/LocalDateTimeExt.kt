package io.github.adrcotfas.datetime.names

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone

/**
 * Returns a localized string representation of this date-time in the specified format styles.
 *
 * The format is determined by the [dateStyle] and [timeStyle] and [locale]. The actual formatting
 * is platform-specific:
 * - On JVM/Android: Uses `DateTimeFormatter.ofLocalizedDateTime(dateStyle, timeStyle)`
 * - On iOS: Uses `NSDateFormatter` with the corresponding date and time styles
 *
 *
 * @param dateStyle The style to use for formatting the date portion (SHORT, MEDIUM, LONG, or FULL).
 *                  Defaults to MEDIUM.
 * @param timeStyle The style to use for formatting the time portion (SHORT, MEDIUM, LONG, or FULL).
 *                  Defaults to MEDIUM. Note that seconds are included in MEDIUM, LONG, and FULL styles.
 * @param locale The locale to use for formatting. Defaults to the platform's default locale.
 * @return A formatted date-time string according to the locale and format styles.
 *
 * @sample
 * ```kotlin
 * val dateTime = LocalDateTime(2024, 12, 1, 15, 30, 0)
 * dateTime.format(FormatStyle.SHORT, FormatStyle.SHORT) // "12/1/24, 3:30 PM" (US locale)
 * dateTime.format(FormatStyle.FULL, FormatStyle.MEDIUM) // "Sunday, December 1, 2024, 3:30:00 PM"
 * ```
 */
expect fun LocalDateTime.format(
    dateStyle: FormatStyle = FormatStyle.MEDIUM,
    timeStyle: FormatStyle = FormatStyle.MEDIUM,
    locale: PlatformLocale = getDefaultLocale(),
    timeZone: TimeZone = TimeZone.currentSystemDefault(),
): String
