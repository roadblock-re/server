package moe.crx.roadblock.updates.mpchallenges

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MultiplayerChallengesStatusUpdate8 : RObject {

    var eventId: Int = 0

    override fun read(sink: InputSink) {
        eventId = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(eventId)
    }

}