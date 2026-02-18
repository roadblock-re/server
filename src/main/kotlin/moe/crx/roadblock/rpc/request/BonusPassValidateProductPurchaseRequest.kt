package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.AsphaltProductID
import moe.crx.roadblock.objects.game.BonusPassId
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket

class BonusPassValidateProductPurchaseRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var bonusPassId: BonusPassId = 0
    var productId: AsphaltProductID = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        bonusPassId = sink.readInt()
        productId = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeInt(bonusPassId)
        sink.writeString(productId)
    }
}