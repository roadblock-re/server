package moe.crx.roadblock.objects.seasonpass

import moe.crx.roadblock.io.EnumIO.readEnum8
import moe.crx.roadblock.io.EnumIO.writeEnum8
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class TierData : RObject {

    var freeRewardState: SeasonPassTierRewardState = SeasonPassTierRewardState.Locked
    var premiumRewardState: SeasonPassTierRewardState = SeasonPassTierRewardState.Locked

    override fun read(sink: InputSink) {
        freeRewardState = sink.readEnum8()
        premiumRewardState = sink.readEnum8()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum8(freeRewardState)
        sink.writeEnum8(premiumRewardState)
    }
}