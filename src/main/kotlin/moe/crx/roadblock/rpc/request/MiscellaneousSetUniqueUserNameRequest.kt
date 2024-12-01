package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.rpc.base.RequestPacket

class MiscellaneousSetUniqueUserNameRequest : RequestPacket() {

    var username: String = ""
    var uniqueNamespace: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        username = sink.readString()
        uniqueNamespace = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(username)
        sink.writeString(uniqueNamespace)
    }
}