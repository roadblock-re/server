package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class FreeTryInfo : RObject {

    var visualId: RInt? = null // CarOfficialVisualIndex

    override fun read(sink: InputSink) {
        visualId = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeOptional(visualId)
    }
}