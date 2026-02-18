package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.UberTierId
import moe.crx.roadblock.objects.uber.UberPoolMissionId
import moe.crx.roadblock.rpc.base.RequestPacket

class UberSpecialEventDiscoverMissionCarsRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var tierId: UberTierId = 0
    var poolMissionId: UberPoolMissionId = UberPoolMissionId()

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        tierId = sink.readInt()
        poolMissionId = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeInt(tierId)
        sink.writeObject(poolMissionId)
    }
}