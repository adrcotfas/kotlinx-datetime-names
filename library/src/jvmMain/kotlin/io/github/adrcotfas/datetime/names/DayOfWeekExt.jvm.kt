package io.github.adrcotfas.datetime.names

import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.isoDayNumber

actual fun DayOfWeek.getDisplayName(
    textStyle: TextStyle,
    locale: PlatformLocale,
): String {
    val javaTextStyle =
        textStyleMapping[textStyle]
            ?: error("Unknown TextStyle: $textStyle")
    return java.time.DayOfWeek
        .of(this.isoDayNumber)
        .getDisplayName(javaTextStyle, locale)
}
