package io.github.adrcotfas.datetime.names

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.Month

/**
 * Common tests that run on all platforms (JVM, Android, iOS, Linux, etc.)
 * These tests verify basic functionality without platform-specific assertions.
 */
class CommonDateTimeNamesTest {
    private val allStyles = TextStyle.entries

    @Test
    fun testAllMonthsWithAllStyles() {
        for (month in Month.entries) {
            for (style in allStyles) {
                val displayName = month.getDisplayName(textStyle = style)
                assertTrue(
                    displayName.isNotEmpty(),
                    "Display name for ${month.name} with style $style should not be empty",
                )
            }
        }
    }

    @Test
    fun testAllDaysWithAllStyles() {
        for (day in DayOfWeek.entries) {
            for (style in allStyles) {
                val displayName = day.getDisplayName(textStyle = style)
                assertTrue(
                    displayName.isNotEmpty(),
                    "Display name for ${day.name} with style $style should not be empty",
                )
            }
        }
    }

    @Test
    fun testMonthNamesAreUnique() {
        val monthNames = Month.entries.map { it.getDisplayName() }
        assertEquals(
            Month.entries.size,
            monthNames.toSet().size,
            "All month names should be unique: $monthNames",
        )
    }

    @Test
    fun testDayOfWeekNamesAreUnique() {
        val dayNames = DayOfWeek.entries.map { it.getDisplayName() }
        assertEquals(
            DayOfWeek.entries.size,
            dayNames.toSet().size,
            "All day of week names should be unique: $dayNames",
        )
    }

    @Test
    fun testNarrowIsNotLongerThanShort() {
        val narrow = Month.JANUARY.getDisplayName(TextStyle.NARROW)
        val short = Month.JANUARY.getDisplayName(TextStyle.SHORT)
        assertTrue(
            narrow.length <= short.length,
            "Narrow style ($narrow) should not be longer than short style ($short)",
        )
    }

    @Test
    fun testShortIsNotLongerThanFull() {
        val short = DayOfWeek.WEDNESDAY.getDisplayName(TextStyle.SHORT)
        val full = DayOfWeek.WEDNESDAY.getDisplayName(TextStyle.FULL)
        assertTrue(
            short.length <= full.length,
            "Short style ($short) should not be longer than full style ($full)",
        )
    }

    @Test
    fun testSameCallReturnsSameResult() {
        val first = Month.MARCH.getDisplayName(textStyle = TextStyle.FULL_STANDALONE)
        val second = Month.MARCH.getDisplayName(textStyle = TextStyle.FULL_STANDALONE)
        assertEquals(first, second, "Multiple calls with same parameters should return same result")
    }
}
