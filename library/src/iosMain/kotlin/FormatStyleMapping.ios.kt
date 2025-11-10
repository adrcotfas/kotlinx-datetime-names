package io.github.adrcotfas.datetime.names

import platform.Foundation.NSDateFormatterFullStyle
import platform.Foundation.NSDateFormatterLongStyle
import platform.Foundation.NSDateFormatterMediumStyle
import platform.Foundation.NSDateFormatterShortStyle

/**
 * Maps our FormatStyle enum to NSDateFormatter style constants.
 */
internal fun FormatStyle.toNSDateFormatterStyle(): ULong =
    when (this) {
        FormatStyle.SHORT -> NSDateFormatterShortStyle
        FormatStyle.MEDIUM -> NSDateFormatterMediumStyle
        FormatStyle.LONG -> NSDateFormatterLongStyle
        FormatStyle.FULL -> NSDateFormatterFullStyle
    }
