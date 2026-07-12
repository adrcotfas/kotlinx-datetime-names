package io.github.adrcotfas.datetime.names

import kotlinx.datetime.Month
import platform.Foundation.NSCalendar

actual fun Month.getDisplayName(
    textStyle: TextStyle,
    locale: PlatformLocale,
): String {
    val calendar =
        NSCalendar.currentCalendar.apply {
            this.locale = locale
        }

    // Month.ordinal is 0-based (JANUARY=0), matching NSCalendar's 0-indexed symbol arrays
    val monthSymbols =
        when (textStyle) {
            TextStyle.FULL -> calendar.monthSymbols
            TextStyle.FULL_STANDALONE -> calendar.standaloneMonthSymbols
            TextStyle.SHORT -> calendar.shortMonthSymbols
            TextStyle.SHORT_STANDALONE -> calendar.shortStandaloneMonthSymbols
            TextStyle.NARROW -> calendar.veryShortMonthSymbols
            TextStyle.NARROW_STANDALONE -> calendar.veryShortStandaloneMonthSymbols
        }

    // In Kotlin/Native, NSArray is mapped to List<*>
    @Suppress("UNCHECKED_CAST")
    return (monthSymbols as List<String>)[this.ordinal]
}
