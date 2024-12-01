package moe.crx.roadblock.objects.tle

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class RankTLEventClaimData : RObject {

    var claimState: Byte = 0
    var rankRewardIdx: Byte = 0

    override fun read(sink: InputSink) {
        claimState = sink.readByte()
        rankRewardIdx = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(claimState)
        sink.writeByte(rankRewardIdx)
    }
}