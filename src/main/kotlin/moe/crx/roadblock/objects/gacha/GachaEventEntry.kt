package moe.crx.roadblock.objects.gacha

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class GachaEventEntry : RObject {

    var eventId: String = ""
    var boxes: List<EventBoxData> = listOf()

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        boxes = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeList(boxes)
    }
}