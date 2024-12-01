package moe.crx.roadblock.objects.career

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class CareerSeasonState : RObject {

    var seasonId: Int = 0
    var state: Int = 0
    var flags: Int = 0

    override fun read(sink: InputSink) {
        seasonId = sink.readInt()
        state = sink.readInt()
        flags = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(seasonId)
        sink.writeInt(state)
        sink.writeInt(flags)
    }
}