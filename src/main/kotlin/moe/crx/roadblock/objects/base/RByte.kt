package moe.crx.roadblock.objects.base

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink

open class RByte(var value: Byte) : RObject {

    constructor() : this(0)

    override fun read(sink: InputSink) {
        value = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(value)
    }
}