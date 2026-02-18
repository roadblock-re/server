package moe.crx.roadblock.objects.dailytasks

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class DailyTask : RObject {

    var isLocked: Boolean = false
    var isClaimed: Boolean = false
    var count: Int = 0
    var isEnabled: Boolean = false

    override fun read(sink: InputSink) {
        isLocked = sink.readBoolean()
        isClaimed = sink.readBoolean()
        count = sink.readInt()
        isEnabled = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeBoolean(isLocked)
        sink.writeBoolean(isClaimed)
        sink.writeInt(count)
        sink.writeBoolean(isEnabled)
    }
}