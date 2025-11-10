package io.github.adrcotfas.datetime.names

// Pre-computed mapping from TextStyle to java.time.format.TextStyle
// Used by JVM target
internal val textStyleMapping =
    mapOf(
        TextStyle.FULL to java.time.format.TextStyle.FULL,
        TextStyle.FULL_STANDALONE to java.time.format.TextStyle.FULL_STANDALONE,
        TextStyle.SHORT to java.time.format.TextStyle.SHORT,
        TextStyle.SHORT_STANDALONE to java.time.format.TextStyle.SHORT_STANDALONE,
        TextStyle.NARROW to java.time.format.TextStyle.NARROW,
        TextStyle.NARROW_STANDALONE to java.time.format.TextStyle.NARROW_STANDALONE,
    )
