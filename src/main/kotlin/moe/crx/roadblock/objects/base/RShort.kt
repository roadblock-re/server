package moe.crx.roadblock.objects.base

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink

open class RShort(var value: Short) : RObject {

    constructor() : this(0)

    override fun read(sink: InputSink) {
        value = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        sink.writeShort(value)
    }
}