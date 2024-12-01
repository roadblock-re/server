package moe.crx.roadblock.updates.club

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.ClubId
import moe.crx.roadblock.objects.game.ClubMemberRank
import moe.crx.roadblock.objects.game.ReputationPoints

class ClubSystemJoinedClub : RObject {

    var id: ClubId = ""
    var reputation: ReputationPoints = 0
    var rank: ClubMemberRank = ClubMemberRank.Manager

    override fun read(sink: InputSink) {
        id = sink.readString()
        reputation = sink.readInt()
        rank = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(id)
        sink.writeInt(reputation)
        sink.writeEnum(rank)
    }
}