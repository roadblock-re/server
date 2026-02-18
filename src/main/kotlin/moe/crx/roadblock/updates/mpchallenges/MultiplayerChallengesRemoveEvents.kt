package moe.crx.roadblock.updates.mpchallenges

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
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