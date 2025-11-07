package io.github.adrcotfas.datetime.names

import kotlinx.datetime.Month

/**
 * Returns the localized display name for this month.
 *
 * This extension function provides localized names for months based on the
 * specified text style and locale. The display name respects the cultural and
 * grammatical conventions of the target locale.
 *
 * @param textStyle The style of the text to return. Determines the length and format
 *                  of the returned string. Defaults to [TextStyle.FULL_STANDALONE].
 *                  - [TextStyle.FULL]: Full name in grammatical form (e.g., "January")
 *                  - [TextStyle.FULL_STANDALONE]: Full name in standalone form
 *                  - [TextStyle.SHORT]: Abbreviated name (e.g., "Jan")
 *                  - [TextStyle.SHORT_STANDALONE]: Abbreviated name in standalone form
 *                  - [TextStyle.NARROW]: Single letter or minimal form (e.g., "J")
 *                  - [TextStyle.NARROW_STANDALONE]: Narrow form in standalone format
 *
 * @param locale The locale to use for formatting. Defaults to [getDefaultLocale].
 *               Different locales will return names in different languages and scripts.
 *
 * @return The localized display name for this month. Never returns null or empty string.
 *
 * @sample
 * ```kotlin
 * // Using default parameters (full standalone, system locale)
 * val monthName = Month.JANUARY.getDisplayName()
 * // English: "January"
 * // French:  "janvier"
 * // German:  "Januar"
 *
 * // Using short style
 * val shortName = Month.FEBRUARY.getDisplayName(TextStyle.SHORT, Locale.ENGLISH)
 * // Returns: "Feb"
 *
 * // Using narrow style
 * val narrowName = Month.MARCH.getDisplayName(TextStyle.NARROW, Locale.ENGLISH)
 * // Returns: "M"
 *
 * // Different locales
 * val japanese = Month.AUGUST.getDisplayName(locale = Locale.JAPANESE)
 * // Returns: "8月"
 *
 * // Standalone vs grammatical forms (important in some languages)
 * // In Polish, March is "marca" when used grammatically ("15 marca 2024")
 * // but "marzec" when used standalone (in a calendar header)
 * val standalone = Month.MARCH.getDisplayName(TextStyle.FULL_STANDALONE, Locale("pl"))
 * // Returns: "marzec"
 * val grammatical = Month.MARCH.getDisplayName(TextStyle.FULL, Locale("pl"))
 * // Returns: "marca"
 * ```
 *
 * @see TextStyle
 * @see PlatformLocale
 * @see getDefaultLocale
 */
expect fun Month.getDisplayName(
    textStyle: TextStyle = TextStyle.FULL_STANDALONE,
    locale: PlatformLocale = getDefaultLocale(),
): String
