package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.rpc.base.RequestPacket

class MiscellaneousSetPlatformRequest : RequestPacket() {

    var currentPlatform: Int = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        currentPlatform = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(currentPlatform)
    }
}