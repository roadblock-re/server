package moe.crx.roadblock.objects.models

import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.relayoffers.RelayOfferEventState

class RelayOfferSystemState : RObject {

    var openedRelayOfferTiers: Map<RString, RelayOfferEventState> = mapOf()

    override fun read(sink: InputSink) {
        openedRelayOfferTiers = sink.readMap()
    }

    override fun write(sink: OutputSink) {
        sink.writeMap(openedRelayOfferTiers)
    }
}