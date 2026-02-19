package moe.crx.roadblock.objects.settings

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

open class Vector2f(var x: Float, var y: Float) : RObject {

    constructor() : this(0f, 0f)

    override fun read(sink: InputSink) {
        x = sink.readFloat()
        y = sink.readFloat()
    }

    override fun write(sink: OutputSink) {
        sink.writeFloat(x)
        sink.writeFloat(y)
    }

    override fun equals(other: Any?): Boolean {
        if (other is Vector2f) {
            return x == other.x && y == other.y
        }

        return false
    }

    override fun hashCode(): Int {
        return x.hashCode() * 31 + y.hashCode()
    }
}