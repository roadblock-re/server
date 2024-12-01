package moe.crx.roadblock.updates.piggybank

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.PiggyBankTierId

class PiggyBankSystemPiggyBankTierAttemptsIncreased : RObject {

    var eventId: CalendarEventId = ""
    var tierId: PiggyBankTierId = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        tierId = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(tierId)
    }
}