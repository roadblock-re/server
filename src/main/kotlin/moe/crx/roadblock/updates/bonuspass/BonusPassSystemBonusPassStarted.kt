package moe.crx.roadblock.updates.bonuspass

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.bonuspass.BonusPassType
import moe.crx.roadblock.objects.game.BonusPassId
import moe.crx.roadblock.objects.game.CalendarEventId

class BonusPassSystemBonusPassStarted : RObject {

    var eventId: CalendarEventId = ""
    var id: BonusPassId = 0
    var startDate: Instant = now()
    var duration: Instant = now()
    var type: BonusPassType = BonusPassType.Multiplayer

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        id = sink.readInt()
        startDate = sink.readInstant()
        duration = sink.readInstant()
        type = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(id)
        sink.writeInstant(startDate)
        sink.writeInstant(duration)
        sink.writeEnum(type)
    }
}