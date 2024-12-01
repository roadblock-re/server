package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.objects.game.CareerEventId
import moe.crx.roadblock.objects.game.ControlSchemeType
import moe.crx.roadblock.rpc.base.RequestPacket

class CareerStartRaceRequest : RequestPacket() {

    var eventId: CareerEventId = 0
    var carId: CarId = 0
    var controlScheme: ControlSchemeType = ControlSchemeType.TouchScreenSmartDrive

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readInt()
        carId = sink.readInt()
        controlScheme = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(eventId)
        sink.writeInt(carId)
        sink.writeEnum(controlScheme)
    }
}