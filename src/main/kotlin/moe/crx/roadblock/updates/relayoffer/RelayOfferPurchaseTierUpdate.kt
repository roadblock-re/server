package moe.crx.roadblock.updates.relayoffer

import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.RelayOfferTierId

class RelayOfferPurchaseTierUpdate : RObject {

    var eventId: CalendarEventId = ""
    var purchasedTierId: RelayOfferTierId = 0
    var walletEventId: RString? = null // CalendarEventId

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        purchasedTierId = sink.readInt()
        walletEventId = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(purchasedTierId)
        sink.writeOptional(walletEventId)
    }
}