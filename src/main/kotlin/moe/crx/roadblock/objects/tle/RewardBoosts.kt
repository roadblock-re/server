package moe.crx.roadblock.objects.tle

import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RFloat
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class RewardBoosts : RObject {

    var creditsBoostPercentage: RFloat? = null
    var tokensBoostPercentage: RFloat? = null
    var rewardMultiplier: RInt? = null

    override fun read(sink: InputSink) {
        creditsBoostPercentage = sink.readOptional()
        tokensBoostPercentage = sink.readOptional()
        rewardMultiplier = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeOptional(creditsBoostPercentage)
        sink.writeOptional(tokensBoostPercentage)
        sink.writeOptional(rewardMultiplier)
    }
}