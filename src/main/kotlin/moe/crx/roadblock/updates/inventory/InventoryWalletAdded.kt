package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.game.CurrencyType
import moe.crx.roadblock.objects.game.Money

class InventoryWalletAdded : RObject {

    var currencyType: CurrencyType = CurrencyType.Credits
    var balance: Money = 0
    var eventId: RString? = null // CalendarEventId

    override fun read(sink: InputSink) {
        currencyType = sink.readEnum()
        balance = sink.readInt()
        eventId = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum(currencyType)
        sink.writeInt(balance)
        sink.writeOptional(eventId)
    }
}