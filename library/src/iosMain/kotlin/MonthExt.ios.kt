package io.github.adrcotfas.datetime.names

import kotlinx.datetime.Month
import kotlinx.datetime.format.MonthNames
import platform.Foundation.NSCalendar
import platform.Foundation.NSLocale

// Cache for calendars per locale to avoid repeated creation
private val calendarCache = mutableMapOf<NSLocale, NSCalendar>()

private fun getOrCreateCalendar(locale: PlatformLocale): NSCalendar {
    return calendarCache.getOrPut(locale) {
        NSCalendar.currentCalendar.apply {
            this.locale = locale
        }
    }
}

actual fun Month.getDisplayName(
    textStyle: TextStyle,
    locale: PlatformLocale,
): String {
    val calendar = getOrCreateCalendar(locale)

    // Month.ordinal is 0-based (JANUARY=0, DECEMBER=11)
    // NSCalendar month symbols are 0-indexed arrays
    val monthSymbols =
        when (textStyle) {
            TextStyle.FULL -> calendar.monthSymbols
            TextStyle.FULL_STANDALONE -> calendar.standaloneMonthSymbols
            TextStyle.SHORT -> calendar.shortMonthSymbols
            TextStyle.SHORT_STANDALONE -> calendar.shortStandaloneMonthSymbols
            TextStyle.NARROW -> calendar.veryShortMonthSymbols
            TextStyle.NARROW_STANDALONE -> calendar.veryShortStandaloneMonthSymbols
        }

    // Safely convert NSArray to List<String>
    // In Kotlin/Native, NSArray is already mapped to List<*>
    @Suppress("UNCHECKED_CAST")
    val monthNames = monthSymbols as? List<String>

    val result = monthNames?.getOrNull(this.ordinal)
    return result ?: when (textStyle) {
        TextStyle.FULL, TextStyle.FULL_STANDALONE -> MonthNames.ENGLISH_FULL.names[this.ordinal]
        TextStyle.SHORT, TextStyle.SHORT_STANDALONE -> MonthNames.ENGLISH_ABBREVIATED.names[this.ordinal]
        TextStyle.NARROW, TextStyle.NARROW_STANDALONE -> MonthNames.ENGLISH_NARROW.names[this.ordinal]
    }
}
