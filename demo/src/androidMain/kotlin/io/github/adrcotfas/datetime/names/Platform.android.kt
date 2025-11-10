package io.github.adrcotfas.datetime.names

import android.os.Build

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
    override val emoji: String = "🤖"
}

actual fun getPlatform(): Platform = AndroidPlatform()
