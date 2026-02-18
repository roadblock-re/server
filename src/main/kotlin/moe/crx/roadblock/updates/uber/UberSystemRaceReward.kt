package moe.crx.roadblock.updates.uber

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.UberTierId
import moe.crx.roadblock.objects.uber.UberPoolMissionId

class UberSystemRaceReward : RObject {

    var eventId: CalendarEventId = ""
    var tierId: UberTierId = 0
    var poolMissionId: UberPoolMissionId = UberPoolMissionId()

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        tierId = sink.readInt()
        poolMissionId = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(tierId)
        sink.writeObject(poolMissionId)
    }
}