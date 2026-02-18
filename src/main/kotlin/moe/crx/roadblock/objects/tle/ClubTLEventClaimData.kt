package moe.crx.roadblock.objects.tle

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.readEnum8
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum8
import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.objects.base.RObject

class ClubTLEventClaimData : RObject {

    var state: ClubTLEventClaimState = ClubTLEventClaimState.Unknown
    var finalProgress: List<RByte> = listOf()
    var claimableRewards: List<RByte> = listOf()

    override fun read(sink: InputSink) {
        state = if (sink newer "24.0.0") {
            sink.readEnum()
        } else {
            sink.readEnum8()
        }
        finalProgress = sink.readList()
        claimableRewards = sink.readList()
    }

    override fun write(sink: OutputSink) {
        if (sink newer "24.0.0") {
            sink.writeEnum(state)
        } else {
            sink.writeEnum8(state)
        }
        sink.writeList(finalProgress)
        sink.writeList(claimableRewards)
    }
}