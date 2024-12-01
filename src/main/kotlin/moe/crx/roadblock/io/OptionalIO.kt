package moe.crx.roadblock.io

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

object OptionalIO {
    inline fun <reified T : RObject> InputSink.readOptional(): T? {
        return readByte().takeIf { it != 0.toByte() }?.let { readObject() }
    }

    fun <T : RObject> OutputSink.writeOptional(optional: T?) {
        writeByte(if (optional != null) 1 else 0)
        optional?.let { writeObject(it) }
    }
}