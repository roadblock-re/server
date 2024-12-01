package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.rpc.base.RequestPacket

class BlackMarketGetStatusRequest : RequestPacket() {

    var shuffleSlots: Boolean = false

    override fun read(sink: InputSink) {
        super.read(sink)
        shuffleSlots = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeBoolean(shuffleSlots)
    }
}