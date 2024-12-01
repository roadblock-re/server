package moe.crx.roadblock.updates.tle

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class TLEventsSystemLockedStateChanged : RObject {

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