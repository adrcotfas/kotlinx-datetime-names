package io.github.adrcotfas.datetime.names

import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone

/**
 * Returns a localized string representation of this date in the specified format style.
 *
 * The format is determined by the [formatStyle] and [locale]. The actual formatting
 * is platform-specific:
 * - On JVM/Android: Uses `DateTimeFormatter.ofLocalizedDate(formatStyle)`
 * - On iOS: Uses `NSDateFormatter` with the corresponding date style
 *
 * @param formatStyle The style to use for formatting (SHORT, MEDIUM, LONG, or FULL).
 *                   Defaults to MEDIUM.
 * @param locale The locale to use for formatting. Defaults to the platform's default locale.
 * @return A formatted date string according to the locale and format style.
 *
 * @sample
 * ```kotlin
 * val date = LocalDate(2024, 12, 1)
 * date.format(FormatStyle.SHORT) // "12/1/24" (US locale)
 * date.format(FormatStyle.FULL)  // "Sunday, December 1, 2024" (US locale)
 * ```
 */
expect fun LocalDate.format(
    formatStyle: FormatStyle = FormatStyle.MEDIUM,
    locale: PlatformLocale = getDefaultLocale(),
    timeZone: TimeZone = TimeZone.currentSystemDefault()
): String
