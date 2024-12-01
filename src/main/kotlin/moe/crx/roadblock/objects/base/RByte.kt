package moe.crx.roadblock.objects.base

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink

class RByte : RObject {

    var value: Byte = 0

    override fun read(sink: InputSink) {
        value = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(value)
    }
}