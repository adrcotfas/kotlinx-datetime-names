package io.github.adrcotfas.datetime.names

import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.format.DayOfWeekNames
import kotlinx.datetime.isoDayNumber
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

actual fun DayOfWeek.getDisplayName(
    textStyle: TextStyle,
    locale: PlatformLocale,
): String {
    val calendar = getOrCreateCalendar(locale)

    // Convert ISO day number (1=Monday, 7=Sunday) to NSCalendar weekday (1=Sunday, 7=Saturday)
    // ISO: Mon=1, Tue=2, Wed=3, Thu=4, Fri=5, Sat=6, Sun=7
    // iOS: Sun=1, Mon=2, Tue=3, Wed=4, Thu=5, Fri=6, Sat=7
    val iosWeekday =
        when (this.isoDayNumber) {
            7 -> 1 // Sunday
            else -> this.isoDayNumber + 1 // Monday-Saturday: add 1
        }

    val weekdaySymbols =
        when (textStyle) {
            TextStyle.FULL -> calendar.weekdaySymbols
            TextStyle.FULL_STANDALONE -> calendar.standaloneWeekdaySymbols
            TextStyle.SHORT -> calendar.shortWeekdaySymbols
            TextStyle.SHORT_STANDALONE -> calendar.shortStandaloneWeekdaySymbols
            TextStyle.NARROW -> calendar.veryShortWeekdaySymbols
            TextStyle.NARROW_STANDALONE -> calendar.veryShortStandaloneWeekdaySymbols
        }

    // Safely convert NSArray to List<String>
    // In Kotlin/Native, NSArray is already mapped to List<*>
    @Suppress("UNCHECKED_CAST")
    val weekdayNames = weekdaySymbols as? List<String>

    val result = weekdayNames?.getOrNull(iosWeekday - 1)
    return result ?: when (textStyle) {
        TextStyle.FULL, TextStyle.FULL_STANDALONE -> DayOfWeekNames.ENGLISH_FULL.names[this.ordinal]
        TextStyle.SHORT, TextStyle.SHORT_STANDALONE -> DayOfWeekNames.ENGLISH_ABBREVIATED.names[this.ordinal]
        TextStyle.NARROW, TextStyle.NARROW_STANDALONE -> DayOfWeekNames.ENGLISH_NARROW.names[this.ordinal]
    }
}
