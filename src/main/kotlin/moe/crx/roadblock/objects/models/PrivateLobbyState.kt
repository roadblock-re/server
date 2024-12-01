package moe.crx.roadblock.objects.models

import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.privatelobby.PrivateLobbyEventState

class PrivateLobbyState : RObject {

    var events: Map<RString, PrivateLobbyEventState> = mapOf()

    override fun read(sink: InputSink) {
        events = sink.readMap()
    }

    override fun write(sink: OutputSink) {
        sink.writeMap(events)
    }
}