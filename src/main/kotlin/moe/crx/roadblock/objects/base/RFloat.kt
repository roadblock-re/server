package moe.crx.roadblock.objects.base

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink

open class RFloat(var value: Float) : RObject {

    constructor() : this(0f)

    override fun read(sink: InputSink) {
        value = sink.readFloat()
    }

    override fun write(sink: OutputSink) {
        sink.writeFloat(value)
    }

    override fun equals(other: Any?): Boolean {
        if (other is RFloat) {
            return value == other.value
        }

        return false
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}