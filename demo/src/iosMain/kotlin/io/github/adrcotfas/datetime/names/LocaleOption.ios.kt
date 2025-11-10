package io.github.adrcotfas.datetime.names

import platform.Foundation.NSLocale

actual fun createLocaleOptions(): List<LocaleOption> =
    listOf(
        LocaleOption("English", NSLocale("en")),
        LocaleOption("Français (French)", NSLocale("fr")),
        LocaleOption("Polski (Polish)", NSLocale("pl")),
        LocaleOption("Română (Romanian)", NSLocale("ro")),
        LocaleOption("中文 (简体) (Chinese Simplified)", NSLocale("zh_Hans")),
        LocaleOption("中文 (繁體) (Chinese Traditional)", NSLocale("zh_Hant")),
    )
