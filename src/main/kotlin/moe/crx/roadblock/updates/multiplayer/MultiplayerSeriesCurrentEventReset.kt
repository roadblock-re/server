package moe.crx.roadblock.updates.multiplayer

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.MultiplayerSeriesId

class MultiplayerSeriesCurrentEventReset : RObject {

    var seriesId: MultiplayerSeriesId = 0

    override fun read(sink: InputSink) {
        seriesId = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(seriesId)
    }
}