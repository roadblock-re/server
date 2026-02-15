package moe.crx.roadblock.io.sinks

import moe.crx.roadblock.serialization.SerializationVersion
import org.fusesource.jansi.Ansi

class OutputAnsiSink(ver: SerializationVersion, val sink: OutputSink? = null) : OutputSink(ver) {

    val ansi = AnsiSink(ver)

    override fun writeBytes(vararg bytes: Byte) {
        ansi.writeBytes(*bytes)
        sink?.writeBytes(*bytes)
    }

    fun result(): Ansi {
        return ansi.result()
    }
}