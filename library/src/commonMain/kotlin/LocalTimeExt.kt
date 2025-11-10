package io.github.adrcotfas.datetime.names

import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone

/**
 * Returns a localized string representation of this time in the specified format style.
 *
 * The format is determined by the [formatStyle] and [locale]. The actual formatting
 * is platform-specific:
 * - On JVM/Android: Uses `DateTimeFormatter.ofLocalizedTime(formatStyle)`
 * - On iOS: Uses `NSDateFormatter` with the corresponding time style
 *
 * Time formatting respects the user's 12-hour vs 24-hour preference on both platforms.
 *
 * **Note:** LONG and FULL styles typically require timezone information and may not work
 * as expected with LocalTime. It's recommended to use SHORT or MEDIUM styles.
 * - SHORT: Hours and minutes only (e.g., "3:30 PM" or "15:30")
 * - MEDIUM: Hours, minutes, and seconds (e.g., "3:30:00 PM" or "15:30:00")
 *
 * @param formatStyle The style to use for formatting. Defaults to SHORT.
 * @param locale The locale to use for formatting. Defaults to the platform's default locale.
 * @return A formatted time string according to the locale and format style.
 *
 * @sample
 * ```kotlin
 * val time = LocalTime(15, 30, 0)
 * time.format(FormatStyle.SHORT)  // "3:30 PM" (US locale, 12-hour) or "15:30" (24-hour)
 * time.format(FormatStyle.MEDIUM) // "3:30:00 PM" (US locale, 12-hour) or "15:30:00" (24-hour)
 * ```
 */
expect fun LocalTime.format(
    formatStyle: FormatStyle = FormatStyle.SHORT,
    locale: PlatformLocale = getDefaultLocale(),
    timeZone: TimeZone = TimeZone.currentSystemDefault(),
): String
