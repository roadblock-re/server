package moe.crx.roadblock.io.sinks

import moe.crx.roadblock.objects.game.SerializationVersion
import org.fusesource.jansi.Ansi

class OutputAnsiSink(val sink: OutputSink, ver: SerializationVersion) : OutputSink(ver) {

    val ansi = AnsiSink(ver)

    override fun writeBytes(vararg bytes: Byte) {
        ansi.writeBytes(*bytes)
        sink.writeBytes(*bytes)
    }

    fun result(): Ansi {
        return ansi.result()
    }
}