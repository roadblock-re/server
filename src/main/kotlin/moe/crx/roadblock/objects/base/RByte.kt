package moe.crx.roadblock.objects.base

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink

open class RByte(var value: Byte) : RObject {

    constructor() : this(0)

    override fun read(sink: InputSink) {
        value = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(value)
    }

    override fun equals(other: Any?): Boolean {
        if (other is RByte) {
            return value == other.value
        }

        return false
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}