package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.rpc.base.RequestPacket

class GainAllCarsCheatRequest : RequestPacket() {

    var placeholder: Int = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        placeholder = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(placeholder)
    }
}