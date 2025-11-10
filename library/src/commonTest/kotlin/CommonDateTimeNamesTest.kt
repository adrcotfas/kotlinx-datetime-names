package io.github.adrcotfas.datetime.names

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.Month

/**
 * Common tests that run on all platforms (JVM, Android, iOS, Linux, etc.)
 * These tests verify basic functionality without platform-specific assertions.
 */
class CommonDateTimeNamesTest {
    // ============ BASIC FUNCTIONALITY TESTS ============

    @Test
    fun testMonthsReturnNonEmptyStrings() {
        for (month in Month.entries) {
            val displayName = month.getDisplayName()
            assertNotNull(displayName, "Display name for ${month.name} should not be null")
            assertTrue(displayName.isNotEmpty(), "Display name for ${month.name} should not be empty")
        }
    }

    @Test
    fun testDaysOfWeekReturnNonEmptyStrings() {
        for (day in DayOfWeek.entries) {
            val displayName = day.getDisplayName()
            assertNotNull(displayName, "Display name for ${day.name} should not be null")
            assertTrue(displayName.isNotEmpty(), "Display name for ${day.name} should not be empty")
        }
    }

    @Test
    fun testAllTextStylesWorkForMonths() {
        val month = Month.JANUARY
        val styles =
            listOf(
                TextStyle.FULL,
                TextStyle.FULL_STANDALONE,
                TextStyle.SHORT,
                TextStyle.SHORT_STANDALONE,
                TextStyle.NARROW,
                TextStyle.NARROW_STANDALONE,
            )

        for (style in styles) {
            val displayName = month.getDisplayName(textStyle = style)
            assertNotNull(displayName, "Display name should not be null for style $style")
            assertTrue(displayName.isNotEmpty(), "Display name should not be empty for style $style")
        }
    }

    @Test
    fun testAllTextStylesWorkForDaysOfWeek() {
        val day = DayOfWeek.MONDAY
        val styles =
            listOf(
                TextStyle.FULL,
                TextStyle.FULL_STANDALONE,
                TextStyle.SHORT,
                TextStyle.SHORT_STANDALONE,
                TextStyle.NARROW,
                TextStyle.NARROW_STANDALONE,
            )

        for (style in styles) {
            val displayName = day.getDisplayName(textStyle = style)
            assertNotNull(displayName, "Display name should not be null for style $style")
            assertTrue(displayName.isNotEmpty(), "Display name should not be empty for style $style")
        }
    }

    // ============ CONSISTENCY TESTS ============

    @Test
    fun testMonthNamesAreUnique() {
        val monthNames = Month.entries.map { it.getDisplayName() }
        val uniqueNames = monthNames.toSet()

        assertEquals(
            Month.entries.size,
            uniqueNames.size,
            "All month names should be unique: $monthNames",
        )
    }

    @Test
    fun testDayOfWeekNamesAreUnique() {
        val dayNames = DayOfWeek.entries.map { it.getDisplayName() }
        val uniqueNames = dayNames.toSet()

        assertEquals(
            DayOfWeek.entries.size,
            uniqueNames.size,
            "All day of week names should be unique: $dayNames",
        )
    }

    @Test
    fun testNarrowIsNotLongerThanShort() {
        val month = Month.JANUARY

        val narrow = month.getDisplayName(TextStyle.NARROW)
        val short = month.getDisplayName(TextStyle.SHORT)

        assertTrue(
            narrow.length <= short.length,
            "Narrow style ($narrow) should not be longer than short style ($short)",
        )
    }

    @Test
    fun testShortIsNotLongerThanFull() {
        val day = DayOfWeek.WEDNESDAY

        val short = day.getDisplayName(TextStyle.SHORT)
        val full = day.getDisplayName(TextStyle.FULL)

        assertTrue(
            short.length <= full.length,
            "Short style ($short) should not be longer than full style ($full)",
        )
    }

    // ============ STABILITY TESTS ============

    @Test
    fun testSameCallReturnsSameResult() {
        val month = Month.MARCH
        val style = TextStyle.FULL_STANDALONE

        val first = month.getDisplayName(textStyle = style)
        val second = month.getDisplayName(textStyle = style)

        assertEquals(first, second, "Multiple calls with same parameters should return same result")
    }

    @Test
    fun testAllMonthsWithAllStyles() {
        val styles =
            listOf(
                TextStyle.FULL,
                TextStyle.FULL_STANDALONE,
                TextStyle.SHORT,
                TextStyle.SHORT_STANDALONE,
                TextStyle.NARROW,
                TextStyle.NARROW_STANDALONE,
            )

        for (month in Month.entries) {
            for (style in styles) {
                val displayName = month.getDisplayName(textStyle = style)
                assertNotNull(
                    displayName,
                    "Display name for ${month.name} with style $style should not be null",
                )
                assertTrue(
                    displayName.isNotEmpty(),
                    "Display name for ${month.name} with style $style should not be empty",
                )
            }
        }
    }

    @Test
    fun testAllDaysWithAllStyles() {
        val styles =
            listOf(
                TextStyle.FULL,
                TextStyle.FULL_STANDALONE,
                TextStyle.SHORT,
                TextStyle.SHORT_STANDALONE,
                TextStyle.NARROW,
                TextStyle.NARROW_STANDALONE,
            )

        for (day in DayOfWeek.entries) {
            for (style in styles) {
                val displayName = day.getDisplayName(textStyle = style)
                assertNotNull(
                    displayName,
                    "Display name for ${day.name} with style $style should not be null",
                )
                assertTrue(
                    displayName.isNotEmpty(),
                    "Display name for ${day.name} with style $style should not be empty",
                )
            }
        }
    }

    // ============ WEEKDAY SPECIFIC TESTS ============

    @Test
    fun testAllWeekdaysPresent() {
        val expectedDays =
            setOf(
                DayOfWeek.MONDAY,
                DayOfWeek.TUESDAY,
                DayOfWeek.WEDNESDAY,
                DayOfWeek.THURSDAY,
                DayOfWeek.FRIDAY,
                DayOfWeek.SATURDAY,
                DayOfWeek.SUNDAY,
            )

        assertEquals(7, expectedDays.size, "Should have exactly 7 days of week")

        for (day in expectedDays) {
            val displayName = day.getDisplayName()
            assertNotNull(displayName, "Day ${day.name} should have a display name")
        }
    }

    @Test
    fun testAllMonthsPresent() {
        val expectedMonths =
            setOf(
                Month.JANUARY,
                Month.FEBRUARY,
                Month.MARCH,
                Month.APRIL,
                Month.MAY,
                Month.JUNE,
                Month.JULY,
                Month.AUGUST,
                Month.SEPTEMBER,
                Month.OCTOBER,
                Month.NOVEMBER,
                Month.DECEMBER,
            )

        assertEquals(12, expectedMonths.size, "Should have exactly 12 months")

        for (month in expectedMonths) {
            val displayName = month.getDisplayName()
            assertNotNull(displayName, "Month ${month.name} should have a display name")
        }
    }
}
