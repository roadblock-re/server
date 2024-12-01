package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.rpc.base.RequestPacket

class XboxLiveOnlyEnableRequest : RequestPacket() {

    var isEnable: Boolean = false
    var debugSuffix: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        isEnable = sink.readBoolean()
        debugSuffix = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeBoolean(isEnable)
        sink.writeString(debugSuffix)
    }
}