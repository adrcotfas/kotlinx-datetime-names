package io.github.adrcotfas.datetime.names

/**
 * Maps our TextStyle enum to java.time's TextStyle enum.
 */
internal fun TextStyle.toJavaTextStyle(): java.time.format.TextStyle =
    when (this) {
        TextStyle.FULL -> java.time.format.TextStyle.FULL
        TextStyle.FULL_STANDALONE -> java.time.format.TextStyle.FULL_STANDALONE
        TextStyle.SHORT -> java.time.format.TextStyle.SHORT
        TextStyle.SHORT_STANDALONE -> java.time.format.TextStyle.SHORT_STANDALONE
        TextStyle.NARROW -> java.time.format.TextStyle.NARROW
        TextStyle.NARROW_STANDALONE -> java.time.format.TextStyle.NARROW_STANDALONE
    }
