package io.github.adrcotfas.datetime.names

/**
 * Formatting styles for dates and times.
 *
 * These styles correspond to standard localized date and time formats:
 * - SHORT: Typically numeric (e.g., "12/13/52" or "3:30 PM")
 * - MEDIUM: Abbreviated (e.g., "Jan 12, 1952" or "3:30:32 PM")
 * - LONG: Full text (e.g., "January 12, 1952" or "3:30:32 PM PST")
 * - FULL: Completely specified (e.g., "Tuesday, April 12, 1952 AD" or "3:30:42 PM PST")
 */
enum class FormatStyle {
    /**
     * Short format style, typically numeric.
     * Example dates: "12/13/52", "1/1/25"
     * Example times: "3:30 PM", "15:30"
     */
    SHORT,

    /**
     * Medium format style, with abbreviated text.
     * Example dates: "Jan 12, 1952", "Dec 1, 2024"
     * Example times: "3:30:32 PM", "15:30:32"
     */
    MEDIUM,

    /**
     * Long format style, with full text.
     * Example dates: "January 12, 1952", "December 1, 2024"
     * Example times: "3:30:32 PM PST", "15:30:32 GMT"
     */
    LONG,

    /**
     * Full format style, completely specified.
     * Example dates: "Tuesday, April 12, 1952 AD", "Monday, December 1, 2024"
     * Example times: "3:30:42 PM PST", "15:30:42 GMT+00:00"
     */
    FULL,
}
