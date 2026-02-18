package moe.crx.roadblock.objects.championship

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ChampionshipClaimData : RObject {

    var state: ChampionshipClaimState = ChampionshipClaimState.Unknown
    var rankRewardIdx: Byte = 0

    override fun read(sink: InputSink) {
        state = sink.readEnum()
        rankRewardIdx = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum(state)
        sink.writeByte(rankRewardIdx)
    }
}