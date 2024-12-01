package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.clubwars.ClubWarsNodeId
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket

class ClubWarsDefenseVacateNodeRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var nodeId: ClubWarsNodeId = ClubWarsNodeId()
    var carId: RInt? = null // CarId
    var debugSuffix: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        nodeId = sink.readObject()
        carId = sink.readOptional()
        debugSuffix = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeObject(nodeId)
        sink.writeOptional(carId)
        sink.writeString(debugSuffix)
    }
}