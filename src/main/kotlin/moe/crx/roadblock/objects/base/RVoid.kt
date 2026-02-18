package moe.crx.roadblock.objects.base

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink

open class RVoid : RObject {

    override fun read(sink: InputSink) {

    }

    override fun write(sink: OutputSink) {

    }

    override fun equals(other: Any?): Boolean {
        return other is RVoid
    }

    override fun hashCode(): Int {
        return 0
    }
}