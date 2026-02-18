package moe.crx.roadblock.rpc.response

import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

class ChampionshipSpecialEventFinishQualifyingPracticeRaceResponse : UpdatesQueueWithRootReactionsResponse() {

    var customAdsMultiplier: RByte? = null
    var defaultAdsMultiplier: RByte? = null

    override fun read(sink: InputSink) {
        super.read(sink)
        customAdsMultiplier = sink.readOptional()
        defaultAdsMultiplier = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeOptional(customAdsMultiplier)
        sink.writeOptional(defaultAdsMultiplier)
    }
}