package moe.crx.roadblock.objects.tle

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.readEnum8
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.EnumIO.writeEnum8
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class RankTLEventClaimData : RObject {

    var state: RankTLEventClaimState = RankTLEventClaimState.Unknown
    var rankRewardIdx: Byte = 0

    override fun read(sink: InputSink) {
        state = if (sink newer "24.0.0") {
            sink.readEnum()
        } else {
            sink.readEnum8()
        }
        rankRewardIdx = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        if (sink newer "24.0.0") {
            sink.writeEnum(state)
        } else {
            sink.writeEnum8(state)
        }
        sink.writeByte(rankRewardIdx)
    }
}