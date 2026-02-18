package moe.crx.roadblock.updates.multiplayer

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInstant
import moe.crx.roadblock.objects.base.RObject

class MultiplayerSeriesMostRecentDisconnectionsChanged : RObject {

    var oldDisconnections: List<RInstant> = listOf()
    var newDisconnections: List<RInstant> = listOf()

    override fun read(sink: InputSink) {
        oldDisconnections = sink.readList()
        newDisconnections = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(oldDisconnections)
        sink.writeList(newDisconnections)
    }
}