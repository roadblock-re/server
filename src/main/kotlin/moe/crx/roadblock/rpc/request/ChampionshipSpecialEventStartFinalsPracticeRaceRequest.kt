package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.objects.game.ChampionshipRoundId
import moe.crx.roadblock.objects.game.ControlSchemeType
import moe.crx.roadblock.rpc.base.RequestPacket

class ChampionshipSpecialEventStartFinalsPracticeRaceRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var roundId: ChampionshipRoundId = 0
    var carId: CarId = 0
    var controlSchemeType: ControlSchemeType = ControlSchemeType.TouchScreenSmartDrive

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        roundId = sink.readInt()
        carId = sink.readInt()
        controlSchemeType = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeInt(roundId)
        sink.writeInt(carId)
        sink.writeEnum(controlSchemeType)
    }
}