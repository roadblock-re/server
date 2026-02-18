package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.GiftId
import moe.crx.roadblock.rpc.base.RequestPacket

class ClaimGiftRequest : RequestPacket() {

    var giftId: GiftId = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        giftId = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(giftId)
    }
}