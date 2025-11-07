package io.github.adrcotfas.datetime.names

import kotlinx.datetime.Month

actual fun Month.getDisplayName(
    textStyle: TextStyle,
    locale: PlatformLocale,
): String {
    val javaTextStyle =
        textStyleMapping[textStyle]
            ?: error("Unknown TextStyle: $textStyle")
    return java.time.Month.of(this.ordinal + 1).getDisplayName(javaTextStyle, locale)
}
