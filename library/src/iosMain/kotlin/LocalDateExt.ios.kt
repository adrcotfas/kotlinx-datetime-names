package io.github.adrcotfas.datetime.names

import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toNSDateComponents
import kotlinx.datetime.toNSTimeZone
import platform.Foundation.NSCalendar
import platform.Foundation.NSDateFormatter

/**
 * iOS implementation of LocalDate formatting using NSDateFormatter.
 */
actual fun LocalDate.format(
    formatStyle: FormatStyle,
    locale: PlatformLocale,
    timeZone: TimeZone
): String {
    val nsComponents = this.toNSDateComponents()
    val dateFormatter =
        NSDateFormatter().apply {
            this.locale = locale
            this.dateStyle = formatStyle.toNSDateFormatterStyle()
            this.timeZone = timeZone.toNSTimeZone()
        }

    val calendar = NSCalendar.currentCalendar
    val date = calendar.dateFromComponents(nsComponents)
        ?: error("Failed to create NSDate from LocalDateTime: $this")

    return dateFormatter.stringFromDate(date)
}
