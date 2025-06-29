package moe.crx.roadblock.objects.championship

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ChampionshipRaceData : RObject {

    var timeInMicroseconds: Int = 0
    var carRank: Short = 0
    var isCarOverclocked: Boolean = false

    override fun read(sink: InputSink) {
        timeInMicroseconds = sink.readInt()
        carRank = sink.readShort()
        if (sink newer "24.0.0") {
            isCarOverclocked = sink.readBoolean()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(timeInMicroseconds)
        sink.writeShort(carRank)
        if (sink newer "24.0.0") {
            sink.writeBoolean(isCarOverclocked)
        }
    }
}
