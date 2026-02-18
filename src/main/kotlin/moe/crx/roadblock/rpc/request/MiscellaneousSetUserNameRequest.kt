package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.rpc.base.RequestPacket

class MiscellaneousSetUserNameRequest : RequestPacket() {

    var username: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        username = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(username)
    }
}