package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.rpc.base.RequestPacket

class MultiplayerChallengesSyncRacesRequest : RequestPacket() {

    var seriesId: Int = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        seriesId = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(seriesId)
    }
}