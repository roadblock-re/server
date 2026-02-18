package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.CurrencyType
import moe.crx.roadblock.rpc.base.RequestPacket

class GainCurrencyCheatRequest : RequestPacket() {

    var currencyType: CurrencyType = CurrencyType.Credits
    var quantity: Int = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        currencyType = sink.readEnum()
        quantity = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeEnum(currencyType)
        sink.writeInt(quantity)
    }
}