package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.objects.game.ControlSchemeType
import moe.crx.roadblock.objects.game.UberTierId
import moe.crx.roadblock.objects.uber.UberPoolMissionId
import moe.crx.roadblock.rpc.base.RequestPacket

class UberSpecialEventStartRaceRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var tierId: UberTierId = 0
    var poolMissionId: UberPoolMissionId = UberPoolMissionId()
    var carId: CarId = 0
    var controlSchemeType: ControlSchemeType = ControlSchemeType.TouchScreenSmartDrive

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        tierId = sink.readInt()
        poolMissionId = sink.readObject()
        carId = sink.readInt()
        controlSchemeType = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeInt(tierId)
        sink.writeObject(poolMissionId)
        sink.writeInt(carId)
        sink.writeEnum(controlSchemeType)
    }
}