package moe.crx.roadblock.updates.piggybank

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.PiggyBankTierId

class PiggyBankSystemPiggyBankCurrentTierChanged : RObject {

    var eventId: CalendarEventId = ""
    var oldTier: PiggyBankTierId = 0
    var newTier: PiggyBankTierId = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        oldTier = sink.readInt()
        newTier = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(oldTier)
        sink.writeInt(newTier)
    }
}