package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class RegionPreferences : RObject {

    var list: List<GenericUserRegionsPreferences> = listOf()

    override fun read(sink: InputSink) {
        list = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(list)
    }
}