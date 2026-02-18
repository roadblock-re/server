package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.CurrencyType
import moe.crx.roadblock.objects.game.Money
import moe.crx.roadblock.rpc.base.RequestPacket

class ChampionshipSpecialEventBuyQualificationRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var currencyType: CurrencyType = CurrencyType.Credits
    var cost: Money = 0
    var debugSuffix: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        currencyType = sink.readEnum()
        cost = sink.readInt()
        debugSuffix = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeEnum(currencyType)
        sink.writeInt(cost)
        sink.writeString(debugSuffix)
    }
}