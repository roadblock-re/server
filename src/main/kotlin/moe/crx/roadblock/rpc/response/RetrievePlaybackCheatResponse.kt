package moe.crx.roadblock.rpc.response

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.rpc.base.ResponsePacket

class RetrievePlaybackCheatResponse : ResponsePacket() {

    var playback: ByteArray = ByteArray(0)

    override fun read(sink: InputSink) {
        super.read(sink)
        playback = sink.readByteArray()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeByteArray(playback)
    }
}