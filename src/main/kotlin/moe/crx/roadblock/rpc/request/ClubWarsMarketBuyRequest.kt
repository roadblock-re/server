package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.objects.game.ClubWarsMarketProductId
import moe.crx.roadblock.objects.game.CurrencyType
import moe.crx.roadblock.objects.game.Money
import moe.crx.roadblock.rpc.base.RequestPacket

class ClubWarsMarketBuyRequest : RequestPacket() {

    var productId: ClubWarsMarketProductId = 0
    var currency: CurrencyType = CurrencyType.Credits
    var cost: Money = 0
    var carId: CarId = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        productId = sink.readInt()
        currency = sink.readEnum()
        cost = sink.readInt()
        carId = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(productId)
        sink.writeEnum(currency)
        sink.writeInt(cost)
        sink.writeInt(carId)
    }
}