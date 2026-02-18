package moe.crx.roadblock.objects.multiplayer

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MultiplayerSeriesTierInfo : RObject {

    var tierId: Byte = 0
    var subTierIndex: Byte = 0

    override fun read(sink: InputSink) {
        tierId = sink.readByte()
        if (sink newer "24.0.0") {
            subTierIndex = sink.readByte()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(tierId)
        if (sink newer "24.0.0") {
            sink.writeByte(subTierIndex)
        }
    }
}