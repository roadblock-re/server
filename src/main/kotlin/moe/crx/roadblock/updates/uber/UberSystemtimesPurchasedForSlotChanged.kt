package moe.crx.roadblock.updates.uber

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.BlackMarketSlotId
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.UberLevelId

class UberSystemtimesPurchasedForSlotChanged : RObject {

    var eventId: CalendarEventId = ""
    var levelId: UberLevelId = 0
    var slotId: BlackMarketSlotId = 0
    var oldTimesPurchased: Int = 0
    var newTimesPurchased: Int = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        levelId = sink.readInt()
        slotId = sink.readByte()
        oldTimesPurchased = sink.readInt()
        newTimesPurchased = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(levelId)
        sink.writeByte(slotId)
        sink.writeInt(oldTimesPurchased)
        sink.writeInt(newTimesPurchased)
    }
}