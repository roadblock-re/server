package moe.crx.roadblock.updates.piggybank

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.Money
import moe.crx.roadblock.objects.game.PiggyBankEventId

class PiggyBankSystemPiggyBankStarted : RObject {

    var eventId: CalendarEventId = ""
    var id: PiggyBankEventId = 0
    var startDate: Instant = now()
    var initialProgress: Money = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        id = sink.readInt()
        startDate = sink.readInstant()
        initialProgress = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(id)
        sink.writeInstant(startDate)
        sink.writeInt(initialProgress)
    }
}