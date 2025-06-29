package moe.crx.roadblock.objects.uber

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.Money
import moe.crx.roadblock.objects.game.UberExperience

class UberSpecialTierData : RObject {

    var xpGainedInTier: UberExperience = 0
    var uberTokensGainedInPinnedMissions: Money = 0

    override fun read(sink: InputSink) {
        xpGainedInTier = sink.readInt()
        uberTokensGainedInPinnedMissions = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(xpGainedInTier)
        sink.writeInt(uberTokensGainedInPinnedMissions)
    }

}
