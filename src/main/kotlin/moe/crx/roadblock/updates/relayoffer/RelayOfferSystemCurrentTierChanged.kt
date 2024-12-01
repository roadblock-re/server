package moe.crx.roadblock.updates.relayoffer

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.RelayOfferTierId

class RelayOfferSystemCurrentTierChanged : RObject {

    var eventId: CalendarEventId = ""
    var newCurrentTierId: RelayOfferTierId = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        newCurrentTierId = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(newCurrentTierId)
    }
}