package moe.crx.roadblock.rpc.response

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.GameRegion
import moe.crx.roadblock.rpc.base.ResponsePacket

class ListRegionsResponse : ResponsePacket() {

    var regions: List<GameRegion> = listOf()

    // TODO Is this long?
    var nextRefreshDelay: Long = Long.MAX_VALUE

    override fun read(sink: InputSink) {
        super.read(sink)
        regions = sink.readList()
        nextRefreshDelay = sink.readLong()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeList(regions)
        sink.writeLong(nextRefreshDelay)
    }
}