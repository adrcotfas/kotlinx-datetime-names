package io.github.adrcotfas.datetime.names

import android.icu.text.DateFormatSymbols

/**
 * Represents a mapping from TextStyle to DateFormatSymbols context and width.
 *
 * @property context The DateFormatSymbols context (FORMAT or STANDALONE)
 * @property width The DateFormatSymbols width (WIDE, ABBREVIATED, or NARROW)
 */
internal data class DateFormatSymbolsStyle(
    val context: Int,
    val width: Int,
)

/**
 * Mapping from TextStyle to DateFormatSymbols context and width.
 * Used by Android target to retrieve localized names using android.icu.text.DateFormatSymbols.
 */
internal val textStyleToDateFormatSymbolsMapping =
    mapOf(
        TextStyle.FULL to
            DateFormatSymbolsStyle(
                context = DateFormatSymbols.FORMAT,
                width = DateFormatSymbols.WIDE,
            ),
        TextStyle.FULL_STANDALONE to
            DateFormatSymbolsStyle(
                context = DateFormatSymbols.STANDALONE,
                width = DateFormatSymbols.WIDE,
            ),
        TextStyle.SHORT to
            DateFormatSymbolsStyle(
                context = DateFormatSymbols.FORMAT,
                width = DateFormatSymbols.ABBREVIATED,
            ),
        TextStyle.SHORT_STANDALONE to
            DateFormatSymbolsStyle(
                context = DateFormatSymbols.STANDALONE,
                width = DateFormatSymbols.ABBREVIATED,
            ),
        TextStyle.NARROW to
            DateFormatSymbolsStyle(
                context = DateFormatSymbols.FORMAT,
                width = DateFormatSymbols.NARROW,
            ),
        TextStyle.NARROW_STANDALONE to
            DateFormatSymbolsStyle(
                context = DateFormatSymbols.STANDALONE,
                width = DateFormatSymbols.NARROW,
            ),
    )
