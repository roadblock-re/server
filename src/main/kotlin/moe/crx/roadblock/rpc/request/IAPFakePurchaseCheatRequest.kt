package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.AsphaltProductID
import moe.crx.roadblock.rpc.base.RequestPacket

class IAPFakePurchaseCheatRequest : RequestPacket() {

    var productId: AsphaltProductID = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        productId = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(productId)
    }
}