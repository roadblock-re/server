package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class GameRegion : RObject {

    var region: String = ""
    var pingAddresses: List<PingAddress> = listOf()

    override fun read(sink: InputSink) {
        region = sink.readString()
        pingAddresses = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(region)
        sink.writeList(pingAddresses)
    }

}
