package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.championship.ChampionshipStageType
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.ChampionshipRoundId
import moe.crx.roadblock.objects.game.CurrencyType
import moe.crx.roadblock.objects.game.Money
import moe.crx.roadblock.rpc.base.RequestPacket

class ChampionshipSpecialEventSkipRewardRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var stageType: ChampionshipStageType = ChampionshipStageType.Qualifying
    var roundId: ChampionshipRoundId = 0
    var rewardIdx: Byte = 0
    var currencyType: CurrencyType = CurrencyType.Credits
    var cost: Money = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        stageType = sink.readEnum()
        roundId = sink.readInt()
        rewardIdx = sink.readByte()
        currencyType = sink.readEnum()
        cost = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeEnum(stageType)
        sink.writeInt(roundId)
        sink.writeByte(rewardIdx)
        sink.writeEnum(currencyType)
        sink.writeInt(cost)
    }
}