package io.github.adrcotfas.datetime.names

data class LocaleOption(
    val displayName: String,
    val locale: PlatformLocale
)

expect fun createLocaleOptions(): List<LocaleOption>
