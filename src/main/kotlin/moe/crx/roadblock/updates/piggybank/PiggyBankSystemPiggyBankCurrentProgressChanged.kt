package moe.crx.roadblock.updates.piggybank

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.Money

class PiggyBankSystemPiggyBankCurrentProgressChanged : RObject {

    var eventId: CalendarEventId = ""
    var oldProgress: Money = 0
    var newProgress: Money = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        oldProgress = sink.readInt()
        newProgress = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(oldProgress)
        sink.writeInt(newProgress)
    }
}