package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.championship.ChampionshipStageType
import moe.crx.roadblock.objects.game.*
import moe.crx.roadblock.rpc.base.RequestPacket

class ChampionshipSpecialEventResetNitroGhostRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var stageType: ChampionshipStageType = ChampionshipStageType.Qualifying
    var roundId: ChampionshipRoundId = 0
    var currencyType: CurrencyType = CurrencyType.Credits
    var cost: Money = 0
    var trackDefId: EventTrackDefId = 0
    var debugSuffix: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        stageType = sink.readEnum()
        roundId = sink.readInt()
        currencyType = sink.readEnum()
        cost = sink.readInt()
        trackDefId = sink.readInt()
        debugSuffix = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeEnum(stageType)
        sink.writeInt(roundId)
        sink.writeEnum(currencyType)
        sink.writeInt(cost)
        sink.writeInt(trackDefId)
        sink.writeString(debugSuffix)
    }
}