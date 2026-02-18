package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.rpc.base.RequestPacket

class RetrievePlaybackCheatRequest : RequestPacket() {

    var userFedId: String = ""
    var playbackName: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        userFedId = sink.readString()
        playbackName = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(userFedId)
        sink.writeString(playbackName)
    }
}