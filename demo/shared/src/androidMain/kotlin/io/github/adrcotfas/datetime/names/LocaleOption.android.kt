package io.github.adrcotfas.datetime.names

import java.util.Locale

actual fun createLocaleOptions(): List<LocaleOption> =
    listOf(
        LocaleOption("English", Locale.ENGLISH),
        LocaleOption("Français (French)", Locale.FRENCH),
        LocaleOption(
            "Polski (Polish)",
            Locale
                .Builder()
                .setLanguage("pl")
                .setRegion("PL")
                .build(),
        ),
        LocaleOption(
            "Română (Romanian)",
            Locale
                .Builder()
                .setLanguage("ro")
                .setRegion("RO")
                .build(),
        ),
        LocaleOption("中文 (简体) (Chinese Simplified)", Locale.SIMPLIFIED_CHINESE),
        LocaleOption("中文 (繁體) (Chinese Traditional)", Locale.TRADITIONAL_CHINESE),
    )
