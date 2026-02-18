package moe.crx.roadblock.objects.base

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink

open class RBoolean(var value: Boolean) : RObject {

    constructor() : this(false)

    override fun read(sink: InputSink) {
        value = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeBoolean(value)
    }

    override fun equals(other: Any?): Boolean {
        if (other is RBoolean) {
            return value == other.value
        }

        return false
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}