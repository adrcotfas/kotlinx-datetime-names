package io.github.adrcotfas.datetime.names

import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.isoDayNumber
import platform.Foundation.NSCalendar

actual fun DayOfWeek.getDisplayName(
    textStyle: TextStyle,
    locale: PlatformLocale,
): String {
    val calendar =
        NSCalendar.currentCalendar.apply {
            this.locale = locale
        }

    // Convert ISO day number (1=Monday, 7=Sunday) to NSCalendar weekday (1=Sunday, 7=Saturday)
    val iosWeekday = if (this.isoDayNumber == 7) 1 else this.isoDayNumber + 1

    val weekdaySymbols =
        when (textStyle) {
            TextStyle.FULL -> calendar.weekdaySymbols
            TextStyle.FULL_STANDALONE -> calendar.standaloneWeekdaySymbols
            TextStyle.SHORT -> calendar.shortWeekdaySymbols
            TextStyle.SHORT_STANDALONE -> calendar.shortStandaloneWeekdaySymbols
            TextStyle.NARROW -> calendar.veryShortWeekdaySymbols
            TextStyle.NARROW_STANDALONE -> calendar.veryShortStandaloneWeekdaySymbols
        }

    // In Kotlin/Native, NSArray is mapped to List<*>
    @Suppress("UNCHECKED_CAST")
    return (weekdaySymbols as List<String>)[iosWeekday - 1]
}
