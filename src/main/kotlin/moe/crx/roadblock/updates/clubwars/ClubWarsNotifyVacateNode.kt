package moe.crx.roadblock.updates.clubwars

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.clubwars.ClubWarsNodeId
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.ClubId

class ClubWarsNotifyVacateNode : RObject {

    var eventId: CalendarEventId = ""
    var nodeId: ClubWarsNodeId = ClubWarsNodeId()
    var clubId: ClubId = ""
    var timestamp: Instant = now()

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        nodeId = sink.readObject()
        clubId = sink.readString()
        timestamp = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeObject(nodeId)
        sink.writeString(clubId)
        sink.writeInstant(timestamp)
    }
}