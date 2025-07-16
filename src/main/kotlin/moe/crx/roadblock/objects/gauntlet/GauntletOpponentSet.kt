package moe.crx.roadblock.objects.gauntlet

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class GauntletOpponentSet : RObject {

    var opponents: List<GauntletOpponentOptional> = listOf()

    override fun read(sink: InputSink) {
        opponents = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(opponents)
    }

}
