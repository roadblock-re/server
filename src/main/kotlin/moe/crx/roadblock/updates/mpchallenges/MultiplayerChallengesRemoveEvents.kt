package moe.crx.roadblock.updates.mpchallenges

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class MultiplayerChallengesRemoveEvents : RObject {

    var eventIds: List<RInt> = listOf()

    override fun read(sink: InputSink) {
        eventIds = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(eventIds)
    }
}