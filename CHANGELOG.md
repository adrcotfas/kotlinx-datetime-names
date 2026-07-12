# Changelog

All notable changes to this project will be documented in this file.

## [0.2.0] - 2026-07-12

### Changed
- **Breaking**: Android minSdk raised from 24 to 26; core library desugaring is no longer required by consumers

### Fixed
- iOS: `LocalDate.format()`, `LocalDateTime.format()` and `LocalTime.format()` shifted the wall-clock values when the `timeZone` parameter differed from the system timezone
- iOS: `LocalTime.format()` could apply historic local-mean-time offsets, producing odd minute values
- iOS: removed an unsynchronized calendar cache that could cause a data race in `Month.getDisplayName()` and `DayOfWeek.getDisplayName()` under concurrent use

## [0.1.2] - 2026-07-07

### Changed
- Updated dependencies (AGP 9, Kotlin 2.4, Compose Multiplatform 1.11, Gradle 9.4)
- Migrated the demo to the recommended Kotlin Multiplatform project structure

## [0.1.1] - 2025-11-10

### Added
- `LocalDateTime.format()` extension function for formatting date-time values with locale-aware styles
- `LocalDate.format()` extension function for formatting dates with locale-aware styles
- `LocalTime.format()` extension function for formatting times with locale-aware styles

### Fixed
- Android localization for `Month` and `DayOfWeek` now uses `android.icu.util` instead of `java.time`, fixing issues with certain languages that have different name versions for FULL vs FULL_STANDALONE styles

## [0.1.0] - 2025-11-07

### Added
- Initial release with localized display names for `DayOfWeek` enum
- Localized display names for `Month` enum
- Support for multiple text styles (FULL, SHORT, NARROW, and standalone variants)
- Platform-specific implementations for JVM, Android, and iOS
