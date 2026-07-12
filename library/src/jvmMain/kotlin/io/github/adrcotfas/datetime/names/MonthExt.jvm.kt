package io.github.adrcotfas.datetime.names

import kotlinx.datetime.Month
import kotlinx.datetime.toJavaMonth

actual fun Month.getDisplayName(
    textStyle: TextStyle,
    locale: PlatformLocale,
): String = this.toJavaMonth().getDisplayName(textStyle.toJavaTextStyle(), locale)
