package moe.crx.roadblock.objects.models

import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.goldenchest.GoldenChestEventState

class GoldenChestSystemState : RObject {

    var eventDataById: Map<RString, GoldenChestEventState> = mapOf()

    override fun read(sink: InputSink) {
        eventDataById = sink.readMap()
    }

    override fun write(sink: OutputSink) {
        sink.writeMap(eventDataById)
    }
}