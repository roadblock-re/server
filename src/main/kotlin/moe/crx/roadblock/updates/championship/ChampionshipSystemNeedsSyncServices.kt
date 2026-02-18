package moe.crx.roadblock.updates.championship

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId

class ChampionshipSystemNeedsSyncServices : RObject {

    var eventId: CalendarEventId = ""
    var needsSync: Boolean = false

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        needsSync = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeBoolean(needsSync)
    }
}