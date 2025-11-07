package io.github.adrcotfas.datetime.names

import kotlinx.datetime.format.DayOfWeekNames

val DayOfWeekNames.Companion.ENGLISH_NARROW: DayOfWeekNames
    get() =
        DayOfWeekNames(
            listOf("M", "T", "W", "T", "F", "S", "S"),
        )
