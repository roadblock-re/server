package moe.crx.roadblock.objects.game

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ActionResponseHeader : RObject {

    var nextActionId: Int = 0
    var lastCommitedActionId: Int = 0
    var clientTime: Instant = now()

    override fun read(sink: InputSink) {
        nextActionId = sink.readInt()
        lastCommitedActionId = sink.readInt()
        clientTime = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(nextActionId)
        sink.writeInt(lastCommitedActionId)
        sink.writeInstant(clientTime)
    }
}