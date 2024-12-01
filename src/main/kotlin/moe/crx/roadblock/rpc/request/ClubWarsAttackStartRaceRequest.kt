package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.clubwars.ClubWarsNodeId
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.objects.game.ControlSchemeType
import moe.crx.roadblock.rpc.base.RequestPacket

class ClubWarsAttackStartRaceRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var nodeId: ClubWarsNodeId = ClubWarsNodeId()
    var carId: CarId = 0
    var controlSchemeType: ControlSchemeType = ControlSchemeType.TouchScreenSmartDrive
    var debugSuffix: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        nodeId = sink.readObject()
        carId = sink.readInt()
        controlSchemeType = sink.readEnum()
        debugSuffix = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeObject(nodeId)
        sink.writeInt(carId)
        sink.writeEnum(controlSchemeType)
        sink.writeString(debugSuffix)
    }
}