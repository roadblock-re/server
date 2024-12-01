package moe.crx.roadblock.objects.clubwars

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ClubWarsParticipationData : RObject {

    var hasClaimedRewards: Boolean = false

    override fun read(sink: InputSink) {
        hasClaimedRewards = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeBoolean(hasClaimedRewards)
    }
}