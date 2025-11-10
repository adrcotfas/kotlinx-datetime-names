package names

import io.github.adrcotfas.datetime.names.TextStyle
import io.github.adrcotfas.datetime.names.getDisplayName
import kotlinx.datetime.Month
import java.util.Locale
import kotlin.test.Test
import kotlin.test.assertNotEquals

class MonthFullVsStandaloneTest {
    @Test
    fun testMonthFullVsStandalone() {
        val polishLocale = Locale.Builder().setLanguage("pl").setRegion("PL").build()

        // Test January
        val januaryFull = Month.JANUARY.getDisplayName(TextStyle.FULL, polishLocale)
        val januaryStandalone =
            Month.JANUARY.getDisplayName(TextStyle.FULL_STANDALONE, polishLocale)

        println("Polish JANUARY FULL: '$januaryFull'")
        println("Polish JANUARY FULL_STANDALONE: '$januaryStandalone'")

        // In Polish, grammatical form is "stycznia" (genitive) and standalone is "styczeń"
        assertNotEquals(
            januaryFull,
            januaryStandalone,
            "Polish month names should differ between FULL and FULL_STANDALONE",
        )

        // Test all months
        for (month in Month.entries) {
            val full = month.getDisplayName(TextStyle.FULL, polishLocale)
            val standalone = month.getDisplayName(TextStyle.FULL_STANDALONE, polishLocale)
            println("Month ${month.name}: FULL='$full', STANDALONE='$standalone'")
        }
    }
}
