package moe.crx.roadblock.objects.models

import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString

class TournamentSystemState : RObject {

    var highestPlacement: Short = 0
    var eventDataById: Map<RString, TournamentEventState> = mapOf()

    override fun read(sink: InputSink) {
        highestPlacement = sink.readShort()
        eventDataById = sink.readMap()
    }

    override fun write(sink: OutputSink) {
        sink.writeShort(highestPlacement)
        sink.writeMap(eventDataById)
    }
}
