package moe.crx.roadblock.updates.piggybank

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.Money
import moe.crx.roadblock.objects.game.PiggyBankTierId

class PiggyBankSystemPiggyBankNotifyTierClaimed : RObject {

    var eventId: CalendarEventId = ""
    var tierId: PiggyBankTierId = 0
    var isFreeClaim: Boolean = false
    var receivedMoney: Money = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        tierId = sink.readInt()
        isFreeClaim = sink.readBoolean()
        receivedMoney = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(tierId)
        sink.writeBoolean(isFreeClaim)
        sink.writeInt(receivedMoney)
    }
}