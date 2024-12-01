package moe.crx.roadblock.updates.clubwars

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ClubWarsMarketLockedStateChanged : RObject {

    var newLockedState: Boolean = false

    override fun read(sink: InputSink) {
        newLockedState = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeBoolean(newLockedState)
    }
}