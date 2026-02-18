package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.Money
import moe.crx.roadblock.rpc.base.RequestPacket

class BlackMarketRefreshRequest : RequestPacket() {

    var tokens: Money = 0
    var shuffleSlots: Boolean = false

    override fun read(sink: InputSink) {
        super.read(sink)
        tokens = sink.readInt()
        shuffleSlots = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(tokens)
        sink.writeBoolean(shuffleSlots)
    }
}