package moe.crx.roadblock.updates.club

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.ReputationPoints

class ClubSystemContributedReputationChanged : RObject {

    var reputation: ReputationPoints = 0

    override fun read(sink: InputSink) {
        reputation = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(reputation)
    }
}