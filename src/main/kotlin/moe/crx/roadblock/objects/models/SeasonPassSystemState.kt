package moe.crx.roadblock.objects.models

import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.seasonpass.SeasonPassPersistentState
import moe.crx.roadblock.objects.seasonpass.SeasonPassState

class SeasonPassSystemState : RObject {

    var currentEvent: String = ""
    var events: Map<RString, SeasonPassState> = mapOf()
    var history: Map<RInt, SeasonPassPersistentState> = mapOf()
    var hasPlayedOnboarding: Boolean = false

    override fun read(sink: InputSink) {
        currentEvent = sink.readString()
        events = sink.readMap()
        history = sink.readMap()
        hasPlayedOnboarding = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(currentEvent)
        sink.writeMap(events)
        sink.writeMap(history)
        sink.writeBoolean(hasPlayedOnboarding)
    }
}