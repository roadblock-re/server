package moe.crx.roadblock.objects.models

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.io.MapIO.readMap
import moe.crx.roadblock.game.io.MapIO.writeMap
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString

class ActivationSystemState : RObject {

    var currentEventData: Map<RString, ActivationEventData> = mapOf()
    var convertedEvents: List<RString> = listOf()

    override fun read(sink: InputSink) {
        currentEventData = sink.readMap()
        convertedEvents = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeMap(currentEventData)
        sink.writeList(convertedEvents)
    }
}
