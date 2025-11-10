package io.github.adrcotfas.datetime.names

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import java.util.Locale
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertTrue

class DateTimeFormattingTest {
    @Test
    fun `test LocalDate formatting with different styles`() {
        val date = LocalDate(2024, 12, 1)
        val locale = Locale.US

        val shortFormat = date.format(FormatStyle.SHORT, locale)
        val mediumFormat = date.format(FormatStyle.MEDIUM, locale)
        val longFormat = date.format(FormatStyle.LONG, locale)
        val fullFormat = date.format(FormatStyle.FULL, locale)

        // All formats should return non-empty strings
        assertTrue(shortFormat.isNotEmpty(), "SHORT format should not be empty")
        assertTrue(mediumFormat.isNotEmpty(), "MEDIUM format should not be empty")
        assertTrue(longFormat.isNotEmpty(), "LONG format should not be empty")
        assertTrue(fullFormat.isNotEmpty(), "FULL format should not be empty")

        // Verify formats contain expected patterns
        println("LocalDate formats:")
        println("  SHORT:  $shortFormat")
        println("  MEDIUM: $mediumFormat")
        println("  LONG:   $longFormat")
        println("  FULL:   $fullFormat")

        // FULL format should contain "Sunday" and "December"
        assertTrue(fullFormat.contains("Sunday") || fullFormat.contains("sunday", ignoreCase = true))
        assertTrue(fullFormat.contains("December") || fullFormat.contains("december", ignoreCase = true))
    }

    @Test
    fun `test LocalTime formatting with different styles`() {
        val time = LocalTime(15, 30, 0)
        val locale = Locale.US

        val shortFormat = time.format(FormatStyle.SHORT, locale)
        val mediumFormat = time.format(FormatStyle.MEDIUM, locale)
        // LONG and FULL fall back to MEDIUM since LocalTime has no timezone
        val longFormat = time.format(FormatStyle.LONG, locale)

        assertTrue(shortFormat.isNotEmpty(), "SHORT format should not be empty")
        assertTrue(mediumFormat.isNotEmpty(), "MEDIUM format should not be empty")
        assertTrue(longFormat.isNotEmpty(), "LONG format should not be empty")

        println("LocalTime formats:")
        println("  SHORT:  $shortFormat")
        println("  MEDIUM: $mediumFormat")
        println("  LONG:   $longFormat (falls back to MEDIUM)")

        // US locale typically uses 12-hour format with PM for 15:30
        // The format should contain either "3" (for 3:30 PM) or "15" (for 15:30)
        assertTrue(shortFormat.contains("3") || shortFormat.contains("15"))
    }

    @Test
    fun `test LocalDateTime formatting with different styles`() {
        val dateTime = LocalDateTime(2024, 12, 1, 15, 30, 0)
        val locale = Locale.US

        val shortShort = dateTime.format(FormatStyle.SHORT, FormatStyle.SHORT, locale)
        val mediumMedium = dateTime.format(FormatStyle.MEDIUM, FormatStyle.MEDIUM, locale)
        // LONG and FULL are formatted separately since LocalDateTime has no timezone
        val longLong = dateTime.format(FormatStyle.LONG, FormatStyle.LONG, locale)
        val fullFull = dateTime.format(FormatStyle.FULL, FormatStyle.FULL, locale)

        assertTrue(shortShort.isNotEmpty(), "SHORT/SHORT format should not be empty")
        assertTrue(mediumMedium.isNotEmpty(), "MEDIUM/MEDIUM format should not be empty")
        assertTrue(longLong.isNotEmpty(), "LONG/LONG format should not be empty")
        assertTrue(fullFull.isNotEmpty(), "FULL/FULL format should not be empty")

        println("LocalDateTime formats:")
        println("  SHORT/SHORT:   $shortShort")
        println("  MEDIUM/MEDIUM: $mediumMedium")
        println("  LONG/LONG:     $longLong")
        println("  FULL/FULL:     $fullFull")
    }

    @Test
    fun `test different locales produce different formats`() {
        val date = LocalDate(2024, 12, 1)

        val usFormat = date.format(FormatStyle.LONG, Locale.US)
        val franceFormat = date.format(FormatStyle.LONG, Locale.FRANCE)
        val germanyFormat = date.format(FormatStyle.LONG, Locale.GERMANY)

        println("LocalDate LONG format in different locales:")
        println("  US:      $usFormat")
        println("  France:  $franceFormat")
        println("  Germany: $germanyFormat")

        // Formats should all be non-empty
        assertTrue(usFormat.isNotEmpty())
        assertTrue(franceFormat.isNotEmpty())
        assertTrue(germanyFormat.isNotEmpty())

        // US format should contain "December"
        assertContains(usFormat, "December", ignoreCase = true)

        // French format should contain "décembre"
        assertContains(franceFormat, "décembre", ignoreCase = true)

        // German format should contain "Dezember"
        assertContains(germanyFormat, "Dezember", ignoreCase = true)
    }
}
