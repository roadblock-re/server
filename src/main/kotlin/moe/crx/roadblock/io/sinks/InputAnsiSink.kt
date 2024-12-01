package moe.crx.roadblock.io.sinks

import moe.crx.roadblock.objects.game.SerializationVersion
import org.fusesource.jansi.Ansi

class InputAnsiSink(val sink: InputSink, ver: SerializationVersion) : InputSink(ver) {

    val ansi = AnsiSink(ver)

    override fun readBytes(n: Int): ByteArray {
        val bytes = sink.readBytes(n)
        ansi.writeBytes(*bytes)
        return bytes
    }

    override fun available(): Int {
        return sink.available()
    }

    fun result(): Ansi {
        return ansi.result()
    }
}