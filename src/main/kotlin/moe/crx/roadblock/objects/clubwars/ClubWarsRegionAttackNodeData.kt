package moe.crx.roadblock.objects.clubwars

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ClubWarsRegionAttackNodeData : RObject {

    var isConquered: Boolean = false
    var isSelectedEntryPoint: Boolean = false

    override fun read(sink: InputSink) {
        isConquered = sink.readBoolean()
        isSelectedEntryPoint = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeBoolean(isConquered)
        sink.writeBoolean(isSelectedEntryPoint)
    }
}