package moe.crx.roadblock.objects.clubwars

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ClubWarsClaimData : RObject {

    var state: Int = 0
    var seasonRewardIdx: Byte = 0
    var leaderboardPosition: Int = 0

    override fun read(sink: InputSink) {
        state = sink.readInt()
        seasonRewardIdx = sink.readByte()
        leaderboardPosition = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(state)
        sink.writeByte(seasonRewardIdx)
        sink.writeInt(leaderboardPosition)
    }
}