package moe.crx.roadblock.objects.base

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink

open class RShort(var value: Short) : RObject {

    constructor() : this(0)

    override fun read(sink: InputSink) {
        value = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        sink.writeShort(value)
    }

    override fun equals(other: Any?): Boolean {
        if (other is RShort) {
            return value == other.value
        }

        return false
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}