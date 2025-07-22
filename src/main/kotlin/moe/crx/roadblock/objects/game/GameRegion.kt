package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
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
