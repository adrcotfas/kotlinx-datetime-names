package io.github.adrcotfas.datetime.names

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform