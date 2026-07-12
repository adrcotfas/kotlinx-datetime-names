package io.github.adrcotfas.datetime.names

import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.toJavaDayOfWeek

actual fun DayOfWeek.getDisplayName(
    textStyle: TextStyle,
    locale: PlatformLocale,
): String = this.toJavaDayOfWeek().getDisplayName(textStyle.toJavaTextStyle(), locale)
