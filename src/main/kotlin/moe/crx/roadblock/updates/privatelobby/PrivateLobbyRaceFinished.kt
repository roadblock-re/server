package moe.crx.roadblock.updates.privatelobby

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId

class PrivateLobbyRaceFinished : RObject {

    var eventId: CalendarEventId = ""
    var position: Byte = 0
    var laps: Int = 0
    var hasFinished: Boolean = false

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        position = sink.readByte()
        laps = sink.readInt()
        hasFinished = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeByte(position)
        sink.writeInt(laps)
        sink.writeBoolean(hasFinished)
    }
}