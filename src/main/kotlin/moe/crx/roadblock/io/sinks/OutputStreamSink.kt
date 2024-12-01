package moe.crx.roadblock.io.sinks

import moe.crx.roadblock.objects.game.SerializationVersion
import java.io.OutputStream

class OutputStreamSink(val output: OutputStream, ver: SerializationVersion) : OutputSink(ver) {

    override fun writeBytes(bytes: ByteArray) {
        output.write(bytes)
        output.flush()
    }
}