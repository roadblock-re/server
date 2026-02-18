package moe.crx.roadblock.updates.miscellaneous

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MiscellaneousUnderageDisclaimerShownChanged : RObject {

    var oldShown: Boolean = false
    var newShown: Boolean = false

    override fun read(sink: InputSink) {
        oldShown = sink.readBoolean()
        newShown = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeBoolean(oldShown)
        sink.writeBoolean(newShown)
    }
}