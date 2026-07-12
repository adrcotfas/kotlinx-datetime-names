package io.github.adrcotfas.datetime.names

import android.icu.text.DateFormatSymbols

/**
 * Maps our TextStyle enum to a DateFormatSymbols (context, width) pair.
 * Used by the Android target to retrieve localized names via android.icu.text.DateFormatSymbols.
 */
internal fun TextStyle.toDateFormatSymbolsStyle(): Pair<Int, Int> =
    when (this) {
        TextStyle.FULL -> DateFormatSymbols.FORMAT to DateFormatSymbols.WIDE
        TextStyle.FULL_STANDALONE -> DateFormatSymbols.STANDALONE to DateFormatSymbols.WIDE
        TextStyle.SHORT -> DateFormatSymbols.FORMAT to DateFormatSymbols.ABBREVIATED
        TextStyle.SHORT_STANDALONE -> DateFormatSymbols.STANDALONE to DateFormatSymbols.ABBREVIATED
        TextStyle.NARROW -> DateFormatSymbols.FORMAT to DateFormatSymbols.NARROW
        TextStyle.NARROW_STANDALONE -> DateFormatSymbols.STANDALONE to DateFormatSymbols.NARROW
    }
