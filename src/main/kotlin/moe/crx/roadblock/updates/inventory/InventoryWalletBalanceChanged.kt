package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.game.CurrencyType
import moe.crx.roadblock.objects.game.Money

class InventoryWalletBalanceChanged : RObject {

    var currencyType: CurrencyType = CurrencyType.Credits
    var oldBalance: Money = 0
    var newBalance: Money = 0
    var seasonPassBonus: RInt? = null // Money
    var bonusPassExtra: RInt? = null // Money
    var eventId: RString? = null // CalendarEventId

    override fun read(sink: InputSink) {
        currencyType = sink.readEnum()
        oldBalance = sink.readInt()
        newBalance = sink.readInt()
        seasonPassBonus = sink.readOptional()
        bonusPassExtra = sink.readOptional()
        eventId = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum(currencyType)
        sink.writeInt(oldBalance)
        sink.writeInt(newBalance)
        sink.writeOptional(seasonPassBonus)
        sink.writeOptional(bonusPassExtra)
        sink.writeOptional(eventId)
    }
}