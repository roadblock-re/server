package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.BlackMarketSlotId
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.Money
import moe.crx.roadblock.objects.game.UberLevelId
import moe.crx.roadblock.rpc.base.RequestPacket

class UberSpecialEventMarketBuyRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var levelId: UberLevelId = 0
    var slotId: BlackMarketSlotId = 0
    var cost: Money = 0
    var amountToBuy: Int = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        levelId = sink.readInt()
        slotId = sink.readByte()
        cost = sink.readInt()
        amountToBuy = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeInt(levelId)
        sink.writeByte(slotId)
        sink.writeInt(cost)
        sink.writeInt(amountToBuy)
    }
}