package io.github.adrcotfas.datetime.names

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toNSDateComponents
import kotlinx.datetime.toNSTimeZone
import platform.Foundation.NSCalendar
import platform.Foundation.NSDateFormatter

/**
 * iOS implementation of LocalDateTime formatting using NSDateFormatter.
 */
actual fun LocalDateTime.format(
    dateStyle: FormatStyle,
    timeStyle: FormatStyle,
    locale: PlatformLocale,
    timeZone: TimeZone,
): String {
    val nsComponents = this.toNSDateComponents()
    val dateFormatter =
        NSDateFormatter().apply {
            this.locale = locale
            this.dateStyle = dateStyle.toNSDateFormatterStyle()
            this.timeStyle = timeStyle.toNSDateFormatterStyle()
            this.timeZone = timeZone.toNSTimeZone()
        }

    val calendar = NSCalendar.currentCalendar
    val date =
        calendar.dateFromComponents(nsComponents)
            ?: error("Failed to create NSDate from LocalDateTime: $this")

    return dateFormatter.stringFromDate(date)
}
