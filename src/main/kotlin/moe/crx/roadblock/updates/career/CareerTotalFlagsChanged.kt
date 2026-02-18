package moe.crx.roadblock.updates.career

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.Flags

class CareerTotalFlagsChanged : RObject {

    var oldFlags: Flags = 0
    var newFlags: Flags = 0

    override fun read(sink: InputSink) {
        oldFlags = sink.readInt()
        newFlags = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(oldFlags)
        sink.writeInt(newFlags)
    }
}