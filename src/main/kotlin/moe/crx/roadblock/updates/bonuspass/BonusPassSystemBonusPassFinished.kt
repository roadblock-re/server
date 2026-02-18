package moe.crx.roadblock.updates.bonuspass

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.BonusPassId
import moe.crx.roadblock.objects.game.CalendarEventId

class BonusPassSystemBonusPassFinished : RObject {

    var eventId: CalendarEventId = ""
    var id: BonusPassId = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        id = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(id)
    }
}