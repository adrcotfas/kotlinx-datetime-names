package io.github.adrcotfas.datetime.names

interface Platform {
    val name: String
    val emoji: String
}

expect fun getPlatform(): Platform
