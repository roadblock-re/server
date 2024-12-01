package moe.crx.roadblock.objects.tle

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.objects.base.RObject

class ClubTLEventData : RObject {

    var completedRewards: List<RByte> = listOf()
    var claimedRewards: List<RByte> = listOf()
    var claimData: ClubTLEventClaimData = ClubTLEventClaimData()

    override fun read(sink: InputSink) {
        completedRewards = sink.readList()
        claimedRewards = sink.readList()
        claimData = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(completedRewards)
        sink.writeList(claimedRewards)
        sink.writeObject(claimData)
    }
}