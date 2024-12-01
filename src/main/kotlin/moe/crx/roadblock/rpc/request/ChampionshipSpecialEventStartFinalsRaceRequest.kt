package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.*
import moe.crx.roadblock.rpc.base.RequestPacket

class ChampionshipSpecialEventStartFinalsRaceRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var roundId: ChampionshipRoundId = 0
    var carId: CarId = 0
    var controlSchemeType: ControlSchemeType = ControlSchemeType.TouchScreenSmartDrive
    var currencyType: CurrencyType = CurrencyType.Credits
    var cost: Money = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        roundId = sink.readInt()
        carId = sink.readInt()
        controlSchemeType = sink.readEnum()
        currencyType = sink.readEnum()
        cost = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeInt(roundId)
        sink.writeInt(carId)
        sink.writeEnum(controlSchemeType)
        sink.writeEnum(currencyType)
        sink.writeInt(cost)
    }
}