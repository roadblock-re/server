package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.rpc.base.RequestPacket

class ProcessPendingSeshatAdTransactionRequest : RequestPacket() {

    var carIdForRefill: RInt? = null // CarId
    var specialCalendarEventId: RString? = null // CalendarEventId
    var relayOfferTierId: RInt? = null // RelayOfferTierId
    var walletEventId: RString? = null // CalendarEventId

    override fun read(sink: InputSink) {
        super.read(sink)
        carIdForRefill = sink.readOptional()
        specialCalendarEventId = sink.readOptional()
        relayOfferTierId = sink.readOptional()
        walletEventId = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeOptional(carIdForRefill)
        sink.writeOptional(specialCalendarEventId)
        sink.writeOptional(relayOfferTierId)
        sink.writeOptional(walletEventId)
    }
}