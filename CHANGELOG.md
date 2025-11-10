# Changelog

All notable changes to this project will be documented in this file.

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
