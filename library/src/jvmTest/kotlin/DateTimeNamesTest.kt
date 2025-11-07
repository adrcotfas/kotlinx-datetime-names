package io.github.adrcotfas.datetime.names

import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.Month
import java.util.Locale
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class DateTimeNamesTest {
    // ============ MONTH TESTS - ENGLISH ============

    @Test
    fun testMonthDisplayNameEnglish() {
        val monthName =
            Month.JANUARY.getDisplayName(
                textStyle = TextStyle.FULL_STANDALONE,
                locale = Locale.ENGLISH,
            )
        assertEquals("January", monthName)
    }

    @Test
    fun testMonthDisplayNameShortEnglish() {
        val monthName =
            Month.FEBRUARY.getDisplayName(
                textStyle = TextStyle.SHORT,
                locale = Locale.ENGLISH,
            )
        assertEquals("Feb", monthName)
    }

    @Test
    fun testMonthDisplayNameNarrowEnglish() {
        val monthName =
            Month.MARCH.getDisplayName(
                textStyle = TextStyle.NARROW,
                locale = Locale.ENGLISH,
            )
        assertEquals("M", monthName)
    }

    @Test
    fun testMonthDisplayNameShortStandaloneEnglish() {
        val monthName =
            Month.APRIL.getDisplayName(
                textStyle = TextStyle.SHORT_STANDALONE,
                locale = Locale.ENGLISH,
            )
        assertEquals("Apr", monthName)
    }

    @Test
    fun testMonthDisplayNameNarrowStandaloneEnglish() {
        val monthName =
            Month.MAY.getDisplayName(
                textStyle = TextStyle.NARROW_STANDALONE,
                locale = Locale.ENGLISH,
            )
        assertEquals("M", monthName)
    }

    @Test
    fun testMonthDisplayNameFullEnglish() {
        val monthName =
            Month.JUNE.getDisplayName(
                textStyle = TextStyle.FULL,
                locale = Locale.ENGLISH,
            )
        assertEquals("June", monthName)
    }

    // ============ DAY OF WEEK TESTS - ENGLISH ============

    @Test
    fun testDayOfWeekDisplayNameEnglish() {
        val dayName =
            DayOfWeek.MONDAY.getDisplayName(
                textStyle = TextStyle.FULL_STANDALONE,
                locale = Locale.ENGLISH,
            )
        assertEquals("Monday", dayName)
    }

    @Test
    fun testDayOfWeekDisplayNameShortEnglish() {
        val dayName =
            DayOfWeek.FRIDAY.getDisplayName(
                textStyle = TextStyle.SHORT,
                locale = Locale.ENGLISH,
            )
        assertEquals("Fri", dayName)
    }

    @Test
    fun testDayOfWeekDisplayNameNarrowEnglish() {
        val dayName =
            DayOfWeek.WEDNESDAY.getDisplayName(
                textStyle = TextStyle.NARROW,
                locale = Locale.ENGLISH,
            )
        assertEquals("W", dayName)
    }

    @Test
    fun testDayOfWeekDisplayNameShortStandaloneEnglish() {
        val dayName =
            DayOfWeek.THURSDAY.getDisplayName(
                textStyle = TextStyle.SHORT_STANDALONE,
                locale = Locale.ENGLISH,
            )
        assertEquals("Thu", dayName)
    }

    @Test
    fun testDayOfWeekDisplayNameNarrowStandaloneEnglish() {
        val dayName =
            DayOfWeek.SATURDAY.getDisplayName(
                textStyle = TextStyle.NARROW_STANDALONE,
                locale = Locale.ENGLISH,
            )
        assertEquals("S", dayName)
    }

    @Test
    fun testDayOfWeekDisplayNameFullEnglish() {
        val dayName =
            DayOfWeek.SUNDAY.getDisplayName(
                textStyle = TextStyle.FULL,
                locale = Locale.ENGLISH,
            )
        assertEquals("Sunday", dayName)
    }

    // ============ MULTI-LOCALE TESTS ============

    @Test
    fun testMonthDisplayNameFrench() {
        val monthName =
            Month.MARCH.getDisplayName(
                textStyle = TextStyle.FULL_STANDALONE,
                locale = Locale.FRENCH,
            )
        assertEquals("mars", monthName)
    }

    @Test
    fun testMonthDisplayNameGerman() {
        val monthName =
            Month.DECEMBER.getDisplayName(
                textStyle = TextStyle.FULL_STANDALONE,
                locale = Locale.GERMAN,
            )
        assertEquals("Dezember", monthName)
    }

    @Test
    fun testMonthDisplayNameItalian() {
        val monthName =
            Month.JULY.getDisplayName(
                textStyle = TextStyle.FULL_STANDALONE,
                locale = Locale.ITALIAN,
            )
        assertEquals("luglio", monthName)
    }

    @Test
    fun testMonthDisplayNameJapanese() {
        val monthName =
            Month.AUGUST.getDisplayName(
                textStyle = TextStyle.FULL_STANDALONE,
                locale = Locale.JAPANESE,
            )
        assertEquals("8月", monthName)
    }

    @Test
    fun testDayOfWeekDisplayNameGerman() {
        val dayName =
            DayOfWeek.WEDNESDAY.getDisplayName(
                textStyle = TextStyle.FULL_STANDALONE,
                locale = Locale.GERMAN,
            )
        assertEquals("Mittwoch", dayName)
    }

    @Test
    fun testDayOfWeekDisplayNameFrench() {
        val dayName =
            DayOfWeek.MONDAY.getDisplayName(
                textStyle = TextStyle.FULL_STANDALONE,
                locale = Locale.FRENCH,
            )
        assertEquals("lundi", dayName)
    }

    @Test
    fun testDayOfWeekDisplayNameItalian() {
        val dayName =
            DayOfWeek.TUESDAY.getDisplayName(
                textStyle = TextStyle.FULL_STANDALONE,
                locale = Locale.ITALIAN,
            )
        assertEquals("martedì", dayName)
    }

    @Test
    fun testDayOfWeekDisplayNameJapanese() {
        val dayName =
            DayOfWeek.SUNDAY.getDisplayName(
                textStyle = TextStyle.FULL_STANDALONE,
                locale = Locale.JAPANESE,
            )
        assertEquals("日曜日", dayName)
    }

    // ============ COMPREHENSIVE COVERAGE TESTS ============

    @Test
    fun testAllMonthsHaveDisplayNames() {
        val locale = Locale.ENGLISH
        for (month in Month.entries) {
            val displayName = month.getDisplayName(locale = locale)
            assertNotNull(displayName)
            assertTrue(displayName.isNotEmpty())
        }
    }

    @Test
    fun testAllDaysOfWeekHaveDisplayNames() {
        val locale = Locale.ENGLISH
        for (day in DayOfWeek.entries) {
            val displayName = day.getDisplayName(locale = locale)
            assertNotNull(displayName)
            assertTrue(displayName.isNotEmpty())
        }
    }

    @Test
    fun testAllTextStylesForMonths() {
        val month = Month.JANUARY
        val locale = Locale.ENGLISH
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
            val displayName = month.getDisplayName(textStyle = style, locale = locale)
            assertNotNull(displayName, "Display name should not be null for style $style")
            assertTrue(displayName.isNotEmpty(), "Display name should not be empty for style $style")
        }
    }

    @Test
    fun testAllTextStylesForDaysOfWeek() {
        val day = DayOfWeek.MONDAY
        val locale = Locale.ENGLISH
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
            val displayName = day.getDisplayName(textStyle = style, locale = locale)
            assertNotNull(displayName, "Display name should not be null for style $style")
            assertTrue(displayName.isNotEmpty(), "Display name should not be empty for style $style")
        }
    }

    @Test
    fun testMultipleLocalesForAllMonths() {
        val locales = listOf(Locale.ENGLISH, Locale.FRENCH, Locale.GERMAN, Locale.ITALIAN)

        for (locale in locales) {
            for (month in Month.entries) {
                val displayName = month.getDisplayName(locale = locale)
                assertNotNull(displayName, "Display name should not be null for ${month.name} in locale ${locale.language}")
                assertTrue(displayName.isNotEmpty(), "Display name should not be empty for ${month.name} in locale ${locale.language}")
            }
        }
    }

    @Test
    fun testMultipleLocalesForAllDaysOfWeek() {
        val locales = listOf(Locale.ENGLISH, Locale.FRENCH, Locale.GERMAN, Locale.ITALIAN)

        for (locale in locales) {
            for (day in DayOfWeek.entries) {
                val displayName = day.getDisplayName(locale = locale)
                assertNotNull(displayName, "Display name should not be null for ${day.name} in locale ${locale.language}")
                assertTrue(displayName.isNotEmpty(), "Display name should not be empty for ${day.name} in locale ${locale.language}")
            }
        }
    }

    // ============ DEFAULT PARAMETER TESTS ============

    @Test
    fun testMonthWithDefaultParameters() {
        val monthName = Month.JANUARY.getDisplayName()
        assertNotNull(monthName)
        assertTrue(monthName.isNotEmpty())
    }

    @Test
    fun testDayOfWeekWithDefaultParameters() {
        val dayName = DayOfWeek.MONDAY.getDisplayName()
        assertNotNull(dayName)
        assertTrue(dayName.isNotEmpty())
    }

    // ============ NARROW vs SHORT DISTINCTION TESTS ============

    @Test
    fun testNarrowIsShorterThanShort() {
        val locale = Locale.ENGLISH
        val month = Month.JANUARY

        val narrow = month.getDisplayName(TextStyle.NARROW, locale)
        val short = month.getDisplayName(TextStyle.SHORT, locale)

        assertTrue(
            narrow.length <= short.length,
            "Narrow style ($narrow) should be shorter than or equal to short style ($short)",
        )
    }

    @Test
    fun testShortIsShorterThanFull() {
        val locale = Locale.ENGLISH
        val day = DayOfWeek.WEDNESDAY

        val short = day.getDisplayName(TextStyle.SHORT, locale)
        val full = day.getDisplayName(TextStyle.FULL, locale)

        assertTrue(
            short.length < full.length,
            "Short style ($short) should be shorter than full style ($full)",
        )
    }

    // ============ WEEKDAY ORDER TESTS ============

    @Test
    fun testAllWeekdaysAreUnique() {
        val locale = Locale.ENGLISH
        val dayNames = DayOfWeek.entries.map { it.getDisplayName(locale = locale) }
        val uniqueNames = dayNames.toSet()

        assertEquals(
            dayNames.size,
            uniqueNames.size,
            "All day names should be unique: $dayNames",
        )
    }

    @Test
    fun testAllMonthsAreUnique() {
        val locale = Locale.ENGLISH
        val monthNames = Month.entries.map { it.getDisplayName(locale = locale) }
        val uniqueNames = monthNames.toSet()

        assertEquals(
            monthNames.size,
            uniqueNames.size,
            "All month names should be unique: $monthNames",
        )
    }
}
