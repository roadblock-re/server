package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MultiplayerSeriesTierInfo : RObject {

    var tierId: MultiplayerSeriesTierId = 0
    var subTierId: MultiplayerSeriesSubTierId = 0

    override fun read(sink: InputSink) {
        tierId = sink.readByte()
        subTierId = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(tierId)
        sink.writeByte(subTierId)
    }
}