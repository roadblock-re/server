package moe.crx.roadblock.game.sinks

import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.core.utils.toHexString
import org.fusesource.jansi.Ansi
import org.fusesource.jansi.Ansi.ansi

class AnsiSink(ver: SerializationVersion) : OutputSink(ver) {
    companion object {
        const val COUNT_OF_COLORS = 7
        const val OFFSET_OF_COLORS = 1
        const val LENGTH_LIMIT = 512
    }

    val console: Ansi = ansi()
    var currentColor = 0
    var currentLength = 0

    fun nextColor() {
        console.fg(Ansi.Color.entries[OFFSET_OF_COLORS + currentColor])
        currentColor = (currentColor + 1) % COUNT_OF_COLORS
    }

    override fun writeBytes(vararg bytes: Byte) {
        nextColor()
        val hex = bytes.toHexString()
        currentLength += hex.length

        if (currentLength <= LENGTH_LIMIT) {
            console.a(hex)
        }
    }

    fun result(): Ansi {
        if (currentLength > LENGTH_LIMIT) {
            console.fg(Ansi.Color.BLACK).a("...")
        }

        currentLength = 0
        return console.reset()
    }
}