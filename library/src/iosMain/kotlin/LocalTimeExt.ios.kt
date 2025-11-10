package io.github.adrcotfas.datetime.names

import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toNSTimeZone
import platform.Foundation.NSCalendar
import platform.Foundation.NSDateComponents
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSDateFormatterNoStyle

/**
 * iOS implementation of LocalTime formatting using NSDateFormatter.
 */
actual fun LocalTime.format(
    formatStyle: FormatStyle,
    locale: PlatformLocale,
    timeZone: TimeZone,
): String {
    val dateFormatter =
        NSDateFormatter().apply {
            this.locale = locale
            this.dateStyle = NSDateFormatterNoStyle
            this.timeStyle = formatStyle.toNSDateFormatterStyle()
        }

    val dateComponents =
        NSDateComponents().apply {
            hour = this@format.hour.toLong()
            minute = this@format.minute.toLong()
            second = this@format.second.toLong()
            this.timeZone = timeZone.toNSTimeZone()
        }

    val calendar = NSCalendar.currentCalendar
    val date =
        calendar.dateFromComponents(dateComponents)
            ?: error("Failed to create NSDate from LocalTime: $this")

    return dateFormatter.stringFromDate(date)
}
