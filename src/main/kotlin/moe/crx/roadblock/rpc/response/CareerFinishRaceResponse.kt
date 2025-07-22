package moe.crx.roadblock.rpc.response

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

class CareerFinishRaceResponse : UpdatesQueueWithRootReactionsResponse() {

    var customAdsMultiplier: RByte? = null
    var defaultAdsMultiplier: RByte? = null

    override fun read(sink: InputSink) {
        super.read(sink)
        if (sink newer "45.0.0") {
            customAdsMultiplier = sink.readOptional()
            defaultAdsMultiplier = sink.readOptional()
        }
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        if (sink newer "45.0.0") {
            sink.writeOptional(customAdsMultiplier)
            sink.writeOptional(defaultAdsMultiplier)
        }
    }
}