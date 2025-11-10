package io.github.adrcotfas.datetime.names

import android.icu.text.DateFormatSymbols
import android.icu.util.ULocale
import kotlinx.datetime.Month

actual fun Month.getDisplayName(
    textStyle: TextStyle,
    locale: PlatformLocale,
): String {
    val symbols = DateFormatSymbols.getInstance(ULocale.forLocale(locale))
    val style =
        textStyleToDateFormatSymbolsMapping[textStyle]
            ?: error("Unknown TextStyle: $textStyle")

    val months = symbols.getMonths(style.context, style.width)
    return months[this.ordinal]
}
