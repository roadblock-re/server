package moe.crx.roadblock.objects.base

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink

open class RInstant(var value: Instant) : RObject {

    constructor() : this(now())

    override fun read(sink: InputSink) {
        value = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeInstant(value)
    }

    override fun equals(other: Any?): Boolean {
        if (other is RInstant) {
            return value == other.value
        }

        return false
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}