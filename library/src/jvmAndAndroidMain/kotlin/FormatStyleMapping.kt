package io.github.adrcotfas.datetime.names

import java.time.format.FormatStyle as JavaFormatStyle

/**
 * Maps our FormatStyle enum to Java's FormatStyle enum.
 */
internal val formatStyleMapping: Map<FormatStyle, JavaFormatStyle> =
    mapOf(
        FormatStyle.SHORT to JavaFormatStyle.SHORT,
        FormatStyle.MEDIUM to JavaFormatStyle.MEDIUM,
        FormatStyle.LONG to JavaFormatStyle.LONG,
        FormatStyle.FULL to JavaFormatStyle.FULL,
    )
