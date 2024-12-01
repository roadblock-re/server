package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.rpc.base.RequestPacket

class UpdateGamertagRequest : RequestPacket() {

    var gamertag: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        gamertag = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(gamertag)
    }
}