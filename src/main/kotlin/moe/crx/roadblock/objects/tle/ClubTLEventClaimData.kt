package moe.crx.roadblock.objects.tle

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.objects.base.RObject

class ClubTLEventClaimData : RObject {

    var state: ClubTLEventClaimState = ClubTLEventClaimState.Unknown
    var finalProgress: List<RByte> = listOf()
    var claimableRewards: List<RByte> = listOf()

    override fun read(sink: InputSink) {
        state = sink.readEnum()
        finalProgress = sink.readList()
        claimableRewards = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum(state)
        sink.writeList(finalProgress)
        sink.writeList(claimableRewards)
    }
}