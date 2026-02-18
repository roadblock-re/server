package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.CurrencyType
import moe.crx.roadblock.objects.game.Money
import moe.crx.roadblock.objects.game.UberTierId
import moe.crx.roadblock.objects.uber.UberPoolMissionId
import moe.crx.roadblock.rpc.base.RequestPacket

class UberSpecialEventSkipMissionRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var tierId: UberTierId = 0
    var poolMissionId: UberPoolMissionId = UberPoolMissionId()
    var currencyType: CurrencyType = CurrencyType.Credits
    var cost: Money = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        tierId = sink.readInt()
        poolMissionId = sink.readObject()
        currencyType = sink.readEnum()
        cost = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeInt(tierId)
        sink.writeObject(poolMissionId)
        sink.writeEnum(currencyType)
        sink.writeInt(cost)
    }
}