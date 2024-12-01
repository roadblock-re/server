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

class InventoryWalletRemoved : RObject {

    var currencyType: CurrencyType = CurrencyType.Credits
    var eventId: RString? = null //CalendarEventId

    override fun read(sink: InputSink) {
        currencyType = sink.readEnum()
        eventId = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum(currencyType)
        sink.writeOptional(eventId)
    }
}