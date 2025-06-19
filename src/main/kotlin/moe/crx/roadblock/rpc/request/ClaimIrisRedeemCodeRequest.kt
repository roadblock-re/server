package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.rpc.base.RequestPacket

class ClaimIrisRedeemCodeRequest : RequestPacket() {

    var code: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        code = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(code)
    }
}