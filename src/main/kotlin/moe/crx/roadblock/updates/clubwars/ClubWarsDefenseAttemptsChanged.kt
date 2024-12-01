package moe.crx.roadblock.updates.clubwars

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.clubwars.ClubWarsNodeId
import moe.crx.roadblock.objects.game.CalendarEventId

class ClubWarsDefenseAttemptsChanged : RObject {

    var eventId: CalendarEventId = ""
    var nodeId: ClubWarsNodeId = ClubWarsNodeId()
    var attempts: Short = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        nodeId = sink.readObject()
        attempts = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeObject(nodeId)
        sink.writeShort(attempts)
    }
}