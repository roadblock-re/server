package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.io.MapIO.readMap
import moe.crx.roadblock.game.io.MapIO.writeMap
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString

class RegionLatencyMap : RObject {

    var map: Map<RString, LatencySamples> = mapOf()

    override fun read(sink: InputSink) {
        map = sink.readMap()
    }

    override fun write(sink: OutputSink) {
        sink.writeMap(map)
    }
}