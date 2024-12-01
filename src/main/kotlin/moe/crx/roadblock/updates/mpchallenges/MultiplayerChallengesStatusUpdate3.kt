package moe.crx.roadblock.updates.mpchallenges

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MultiplayerChallengesStatusUpdate3 : RObject {

    var eventId: Int = 0
    var revealedSponsorsStep: Byte = 0

    override fun read(sink: InputSink) {
        eventId = sink.readInt()
        revealedSponsorsStep = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(eventId)
        sink.writeByte(revealedSponsorsStep)
    }
}