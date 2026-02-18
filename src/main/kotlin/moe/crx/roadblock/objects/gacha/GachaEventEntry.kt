package moe.crx.roadblock.objects.gacha

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class GachaEventEntry : RObject {
    var boxes: List<EventBoxData> = listOf()

    override fun read(sink: InputSink) {
        boxes = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(boxes)
    }
}