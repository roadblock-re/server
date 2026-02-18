package moe.crx.roadblock.objects.club

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class ClubSeasonEvent : RObject {

    var baseReputation: Int = 0
    var clubReputation: Int = 0
    var contributedReputation: Int = 0
    var claimedMilestones: List<RInt> = listOf()
    var claimableAfterFinishedByClub: String = ""

    override fun read(sink: InputSink) {
        baseReputation = sink.readInt()
        clubReputation = sink.readInt()
        contributedReputation = sink.readInt()
        claimedMilestones = sink.readList()
        claimableAfterFinishedByClub = sink.readString()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(baseReputation)
        sink.writeInt(clubReputation)
        sink.writeInt(contributedReputation)
        sink.writeList(claimedMilestones)
        sink.writeString(claimableAfterFinishedByClub)
    }
}