package moe.crx.roadblock.objects.multiplayer

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MultiplayerSeriesTierInfo : RObject {

    var tierId: Byte = 0
    var subTierIndex: Byte = 0

    override fun read(sink: InputSink) {
        tierId = sink.readByte()
        subTierIndex = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(tierId)
        sink.writeByte(subTierIndex)
    }
}