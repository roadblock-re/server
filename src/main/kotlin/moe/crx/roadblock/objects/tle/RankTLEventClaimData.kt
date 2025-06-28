package moe.crx.roadblock.objects.tle

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class RankTLEventClaimData : RObject {

    var claimState: RankTLEventClaimState = RankTLEventClaimState.Unknown
    var rankRewardIdx: Byte = 0

    override fun read(sink: InputSink) {
        claimState = sink.readEnum()
        rankRewardIdx = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum(claimState)
        sink.writeByte(rankRewardIdx)
    }
}