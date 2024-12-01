package moe.crx.roadblock.updates.uber

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.Money
import moe.crx.roadblock.objects.game.UberTierId

class UberSystemUberCurrencyObtainedInPinnedMissionChanged : RObject {

    var eventId: CalendarEventId = ""
    var tierId: UberTierId = 0
    var oldAmount: Money = 0
    var newAmount: Money = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        tierId = sink.readInt()
        oldAmount = sink.readInt()
        newAmount = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(tierId)
        sink.writeInt(oldAmount)
        sink.writeInt(newAmount)
    }
}