package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class InventoryMuteEmojisChanged : RObject {

    var muted: Boolean = false

    override fun read(sink: InputSink) {
        muted = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeBoolean(muted)
    }
}