package moe.crx.roadblock.objects.base

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink

open class RByteArray(var value: ByteArray) : RObject {

    constructor() : this(ByteArray(0))

    override fun read(sink: InputSink) {
        value = sink.readByteArray()
    }

    override fun write(sink: OutputSink) {
        sink.writeByteArray(value)
    }

    override fun equals(other: Any?): Boolean {
        if (other is RByteArray) {
            return value.contentEquals(other.value)
        }

        return false
    }

    override fun hashCode(): Int {
        return value.contentHashCode()
    }
}