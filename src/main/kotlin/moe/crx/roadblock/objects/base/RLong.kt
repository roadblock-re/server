package moe.crx.roadblock.objects.base

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink

open class RLong(var value: Long) : RObject {

    constructor() : this(0)

    override fun read(sink: InputSink) {
        value = sink.readLong()
    }

    override fun write(sink: OutputSink) {
        sink.writeLong(value)
    }

    override fun equals(other: Any?): Boolean {
        if (other is RLong) {
            return value == other.value
        }

        return false
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}