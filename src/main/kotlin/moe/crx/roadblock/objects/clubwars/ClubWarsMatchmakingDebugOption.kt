package moe.crx.roadblock.objects.clubwars

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ClubWarsMatchmakingDebugOption : RObject {

    var force: Boolean = false

    override fun read(sink: InputSink) {
        force = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeBoolean(force)
    }
}