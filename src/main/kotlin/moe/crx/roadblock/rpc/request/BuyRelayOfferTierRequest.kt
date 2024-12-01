package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.RelayOfferTierId
import moe.crx.roadblock.rpc.base.RequestPacket

class BuyRelayOfferTierRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var tierId: RelayOfferTierId = 0
    var walletEventId: RString? = null // CalendarEventId

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        tierId = sink.readInt()
        walletEventId = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeInt(tierId)
        sink.writeOptional(walletEventId)
    }
}