package moe.crx.roadblock.updates.uber

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.UberTierId
import moe.crx.roadblock.objects.uber.UberPoolMissionId

class UberSystemMissionCompleted : RObject {

    var eventId: CalendarEventId = ""
    var tierId: UberTierId = 0
    var poolMissionId: UberPoolMissionId = UberPoolMissionId()
    var isSkip: Boolean = false

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        tierId = sink.readInt()
        poolMissionId = sink.readObject()
        isSkip = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(tierId)
        sink.writeObject(poolMissionId)
        sink.writeBoolean(isSkip)
    }
}