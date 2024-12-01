package moe.crx.roadblock.updates.championship

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.EventTrackDefId

class ChampionshipSystemBestNitroGhostTimeChanged : RObject {

    var eventId: CalendarEventId = ""
    var trackDefId: EventTrackDefId = 0
    var ghostTimeMicroseconds: Int = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        trackDefId = sink.readInt()
        ghostTimeMicroseconds = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(trackDefId)
        sink.writeInt(ghostTimeMicroseconds)
    }
}