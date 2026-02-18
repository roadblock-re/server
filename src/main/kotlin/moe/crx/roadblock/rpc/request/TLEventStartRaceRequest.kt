package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.objects.game.ControlSchemeType
import moe.crx.roadblock.objects.tle.TLEventId
import moe.crx.roadblock.rpc.base.RequestPacket

class TLEventStartRaceRequest : RequestPacket() {

    var eventId: TLEventId = TLEventId()
    var carId: CarId = 0
    var controlScheme: ControlSchemeType = ControlSchemeType.TouchScreenSmartDrive

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readObject()
        carId = sink.readInt()
        controlScheme = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeObject(eventId)
        sink.writeInt(carId)
        sink.writeEnum(controlScheme)
    }
}