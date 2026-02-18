package moe.crx.roadblock.objects.models

import moe.crx.roadblock.game.io.MapIO.readMap
import moe.crx.roadblock.game.io.MapIO.writeMap
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.privatelobby.PrivateLobbyEventData

class PrivateLobbyState : RObject {

    var events: Map<RString, PrivateLobbyEventData> = mapOf()

    override fun read(sink: InputSink) {
        events = sink.readMap()
    }

    override fun write(sink: OutputSink) {
        sink.writeMap(events)
    }
}