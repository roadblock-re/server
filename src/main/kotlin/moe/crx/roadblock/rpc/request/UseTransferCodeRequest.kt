package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.rpc.base.RequestPacket

class UseTransferCodeRequest : RequestPacket() {

    var code: String = ""

    override fun read(sink: InputSink) {
        code = sink.readString()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(code)
    }
}