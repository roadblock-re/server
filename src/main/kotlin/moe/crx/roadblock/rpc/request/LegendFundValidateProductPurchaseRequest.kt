package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.AsphaltProductID
import moe.crx.roadblock.objects.game.LegendFundTierId
import moe.crx.roadblock.rpc.base.RequestPacket

class LegendFundValidateProductPurchaseRequest : RequestPacket() {

    var productId: AsphaltProductID = ""
    var tierId: LegendFundTierId = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        productId = sink.readString()
        tierId = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(productId)
        sink.writeShort(tierId)
    }
}