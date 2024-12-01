package moe.crx.roadblock.objects.base

import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.SerializationVersion
import moe.crx.roadblock.utils.byteOutputSink
import moe.crx.roadblock.utils.bytes

interface RObject {
    companion object {
        fun RObject.bytes(ver: SerializationVersion): ByteArray {
            return byteOutputSink(ver).apply {
                writeObject(this@bytes)
            }.bytes()
        }
    }

    fun read(sink: InputSink)
    fun write(sink: OutputSink)
}
