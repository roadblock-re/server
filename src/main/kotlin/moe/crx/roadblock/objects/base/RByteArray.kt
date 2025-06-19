package moe.crx.roadblock.objects.base

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink

class RByteArray : RObject {

    var value: ByteArray = ByteArray(0)

    override fun read(sink: InputSink) {
        value = sink.readByteArray()
    }

    override fun write(sink: OutputSink) {
        sink.writeByteArray(value)
    }
}