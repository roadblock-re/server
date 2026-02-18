package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.rpc.base.RequestPacket

class FindOnlineUserByAliasRequest : RequestPacket() {

    var alias: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        alias = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(alias)
    }
}