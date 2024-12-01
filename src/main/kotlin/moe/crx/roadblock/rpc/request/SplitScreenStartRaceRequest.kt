package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.rpc.base.RequestPacket

class SplitScreenStartRaceRequest : RequestPacket() {

    var playersCount: Int = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        playersCount = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(playersCount)
    }
}