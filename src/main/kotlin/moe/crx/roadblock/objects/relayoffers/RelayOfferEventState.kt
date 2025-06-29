package moe.crx.roadblock.objects.relayoffers

import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.RelayOfferTierId

class RelayOfferEventState : RObject {

    var currentPurchasableTier: RelayOfferTierId = 0
    var amountOfPurchasesPerTier: Map<RInt, RByte> = mapOf() // RelayOfferTierId

    override fun read(sink: InputSink) {
        currentPurchasableTier = sink.readInt()
        amountOfPurchasesPerTier = sink.readMap()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(currentPurchasableTier)
        sink.writeMap(amountOfPurchasesPerTier)
    }
}