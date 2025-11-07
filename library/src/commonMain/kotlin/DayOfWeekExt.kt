package io.github.adrcotfas.datetime.names

import kotlinx.datetime.DayOfWeek

/**
 * Returns the localized display name for this day of the week.
 *
 * This extension function provides localized names for days of the week based on the
 * specified text style and locale. The display name respects the cultural conventions
 * of the target locale.
 *
 * @param textStyle The style of the text to return. Determines the length and format
 *                  of the returned string. Defaults to [TextStyle.FULL_STANDALONE].
 *                  - [TextStyle.FULL]: Full name in grammatical form (e.g., "Monday")
 *                  - [TextStyle.FULL_STANDALONE]: Full name in standalone form
 *                  - [TextStyle.SHORT]: Abbreviated name (e.g., "Mon")
 *                  - [TextStyle.SHORT_STANDALONE]: Abbreviated name in standalone form
 *                  - [TextStyle.NARROW]: Single letter or minimal form (e.g., "M")
 *                  - [TextStyle.NARROW_STANDALONE]: Narrow form in standalone format
 *
 * @param locale The locale to use for formatting. Defaults to [getDefaultLocale].
 *               Different locales will return names in different languages and scripts.
 *
 * @return The localized display name for this day of the week. Never returns null or empty string.
 *
 * @sample
 * ```kotlin
 * // Using default parameters (full standalone, system locale)
 * val dayName = DayOfWeek.MONDAY.getDisplayName()
 * // English: "Monday"
 * // French:  "lundi"
 * // German:  "Montag"
 *
 * // Using short style
 * val shortName = DayOfWeek.FRIDAY.getDisplayName(TextStyle.SHORT, Locale.ENGLISH)
 * // Returns: "Fri"
 *
 * // Using narrow style
 * val narrowName = DayOfWeek.WEDNESDAY.getDisplayName(TextStyle.NARROW, Locale.ENGLISH)
 * // Returns: "W"
 *
 * // Different locales
 * val japanese = DayOfWeek.SUNDAY.getDisplayName(locale = Locale.JAPANESE)
 * // Returns: "日曜日"
 * ```
 *
 * @see TextStyle
 * @see PlatformLocale
 * @see getDefaultLocale
 */
expect fun DayOfWeek.getDisplayName(
    textStyle: TextStyle = TextStyle.FULL_STANDALONE,
    locale: PlatformLocale = getDefaultLocale(),
): String
