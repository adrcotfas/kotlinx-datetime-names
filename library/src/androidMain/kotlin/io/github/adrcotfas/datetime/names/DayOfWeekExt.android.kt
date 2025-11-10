package io.github.adrcotfas.datetime.names

import android.icu.text.DateFormatSymbols
import android.icu.util.ULocale
import kotlinx.datetime.DayOfWeek

actual fun DayOfWeek.getDisplayName(
    textStyle: TextStyle,
    locale: PlatformLocale,
): String {
    val symbols = DateFormatSymbols.getInstance(ULocale.forLocale(locale))
    val style =
        textStyleToDateFormatSymbolsMapping[textStyle]
            ?: error("Unknown TextStyle: $textStyle")

    // ICU weekdays are 1-based (Sunday=1), kotlinx.datetime is ISO (Monday=1, Sunday=7)
    // Convert: Monday(1)→2, Tuesday(2)→3, ..., Saturday(6)→7, Sunday(7)→1
    val icuDayIndex = if (this == DayOfWeek.SUNDAY) 1 else this.ordinal + 2

    val days = symbols.getWeekdays(style.context, style.width)
    return days[icuDayIndex]
}
