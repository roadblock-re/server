package moe.crx.roadblock.updates.clubrace

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.ClubRaceEventId

class ClubRaceFinished : RObject {

    var position: Byte = 0
    var eventId: ClubRaceEventId = 0
    var laps: Int = 0
    var hasFinished: Boolean = false

    override fun read(sink: InputSink) {
        position = sink.readByte()
        eventId = sink.readInt()
        laps = sink.readInt()
        hasFinished = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(position)
        sink.writeInt(eventId)
        sink.writeInt(laps)
        sink.writeBoolean(hasFinished)
    }
}