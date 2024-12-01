package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.rpc.base.RequestPacket

class SeasonPassSetPlayedOnboardingCheatRequest : RequestPacket() {

    var hasPlayed: Boolean = false

    override fun read(sink: InputSink) {
        super.read(sink)
        hasPlayed = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeBoolean(hasPlayed)
    }
}