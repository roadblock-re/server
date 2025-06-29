package moe.crx.roadblock.objects.game

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ActionRequestHeader : RObject {

    var actionId: Int = 0
    var clientId: String = ""
    var clientTime: Instant = now()

    override fun read(sink: InputSink) {
        actionId = sink.readInt()
        clientId = sink.readString()
        if (sink newer "24.1.0") {
            clientTime = sink.readInstant()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(actionId)
        sink.writeString(clientId)
        if (sink newer "24.1.0") {
            sink.writeInstant(clientTime)
        }
    }
}