package moe.crx.roadblock.updates.multiplayer

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MultiplayerSeriesLockedStateChanged : RObject {

    var oldLockedState: Boolean = false
    var newLockedState: Boolean = false

    override fun read(sink: InputSink) {
        oldLockedState = sink.readBoolean()
        newLockedState = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeBoolean(oldLockedState)
        sink.writeBoolean(newLockedState)
    }
}