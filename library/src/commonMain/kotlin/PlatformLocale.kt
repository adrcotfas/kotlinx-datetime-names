package io.github.adrcotfas.datetime.names

/*
 * Copyright 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Platform-specific locale representation.
 *
 * On JVM/Android, this is `java.util.Locale`.
 * On iOS, this is `platform.Foundation.NSLocale`.
 *
 * This class abstracts platform-specific locale implementations to provide a unified
 * API for locale-based operations across different platforms.
 *
 * @see getDefaultLocale
 */
expect class PlatformLocale

/**
 * Returns the default locale for the current platform.
 *
 * This function retrieves the system's current locale setting, which determines
 * the language and region preferences for formatting dates, numbers, and other
 * locale-sensitive data.
 *
 * **Platform-specific behavior:**
 * - **JVM/Android**: Returns `Locale.getDefault()`
 * - **iOS**: Returns `NSLocale.currentLocale`
 *
 * @return The current system locale
 *
 * @sample
 * ```kotlin
 * val locale = getDefaultLocale()
 * val monthName = Month.JANUARY.getDisplayName(locale = locale)
 * ```
 */
expect fun getDefaultLocale(): PlatformLocale
