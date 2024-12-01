package moe.crx.roadblock.objects.clubwars

import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RShort

class ClubWarsBoardAttackRegion : RObject {

    var nodes: Map<RShort, ClubWarsRegionAttackNodeData> = mapOf()

    override fun read(sink: InputSink) {
        nodes = sink.readMap()
    }

    override fun write(sink: OutputSink) {
        sink.writeMap(nodes)
    }
}