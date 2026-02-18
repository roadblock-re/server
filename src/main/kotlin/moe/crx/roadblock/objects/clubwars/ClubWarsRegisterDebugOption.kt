package moe.crx.roadblock.objects.clubwars

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ClubWarsRegisterDebugOption : RObject {

    var ignoreChecks: Boolean = false

    override fun read(sink: InputSink) {
        ignoreChecks = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeBoolean(ignoreChecks)
    }
}