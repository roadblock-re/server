package moe.crx.roadblock.updates.mpchallenges

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MultiplayerChallengesStatusUpdate10 : RObject {

    var eventId: Int = 0
    var finishedId: Byte = 0

    override fun read(sink: InputSink) {
        eventId = sink.readInt()
        finishedId = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(eventId)
        sink.writeByte(finishedId)
    }
}