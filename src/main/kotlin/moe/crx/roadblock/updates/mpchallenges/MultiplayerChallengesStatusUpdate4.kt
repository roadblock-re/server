package moe.crx.roadblock.updates.mpchallenges

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MultiplayerChallengesStatusUpdate4 : RObject {

    var eventId: Int = 0
    var selectedSponsor: Int = 0

    override fun read(sink: InputSink) {
        eventId = sink.readInt()
        selectedSponsor = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(eventId)
        sink.writeInt(selectedSponsor)
    }
}