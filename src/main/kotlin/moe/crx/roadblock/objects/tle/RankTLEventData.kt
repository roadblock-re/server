package moe.crx.roadblock.objects.tle

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class RankTLEventData : RObject {

    var leaderboardPosition: Int = 0
    var entryCount: Int = 0
    var claimData: RankTLEventClaimData = RankTLEventClaimData()

    override fun read(sink: InputSink) {
        leaderboardPosition = sink.readInt()
        entryCount = sink.readInt()
        claimData = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(leaderboardPosition)
        sink.writeInt(entryCount)
        sink.writeObject(claimData)
    }
}