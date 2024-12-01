package moe.crx.roadblock.updates.seasonpass

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class SeasonPassSystemPlayedOnboardingChanged : RObject {

    var played: Boolean = false

    override fun read(sink: InputSink) {
        played = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeBoolean(played)
    }
}