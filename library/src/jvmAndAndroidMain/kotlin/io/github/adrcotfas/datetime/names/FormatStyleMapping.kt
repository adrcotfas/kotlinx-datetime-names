package io.github.adrcotfas.datetime.names

import java.time.format.FormatStyle as JavaFormatStyle

/**
 * Maps our FormatStyle enum to Java's FormatStyle enum.
 */
internal fun FormatStyle.toJavaFormatStyle(): JavaFormatStyle =
    when (this) {
        FormatStyle.SHORT -> JavaFormatStyle.SHORT
        FormatStyle.MEDIUM -> JavaFormatStyle.MEDIUM
        FormatStyle.LONG -> JavaFormatStyle.LONG
        FormatStyle.FULL -> JavaFormatStyle.FULL
    }
