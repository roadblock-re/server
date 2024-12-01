package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.blackmarket.BlackMarketItemVariant
import moe.crx.roadblock.objects.game.BlackMarketSlotId
import moe.crx.roadblock.objects.game.CurrencyType
import moe.crx.roadblock.objects.game.Money
import moe.crx.roadblock.rpc.base.RequestPacket

class BlackMarketBuyRequest : RequestPacket() {

    var slot: BlackMarketSlotId = 0
    var item: BlackMarketItemVariant = BlackMarketItemVariant()
    var amount: Byte = 0
    var currencyType: CurrencyType = CurrencyType.Credits
    var cost: Money = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        slot = sink.readByte()
        item = sink.readObject()
        amount = sink.readByte()
        currencyType = sink.readEnum()
        cost = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeByte(slot)
        sink.writeObject(item)
        sink.writeByte(amount)
        sink.writeEnum(currencyType)
        sink.writeInt(cost)
    }
}