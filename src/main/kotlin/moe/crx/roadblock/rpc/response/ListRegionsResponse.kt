package moe.crx.roadblock.rpc.response

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.GameRegion
import moe.crx.roadblock.rpc.base.ResponsePacket

class ListRegionsResponse : ResponsePacket() {

    var regions: List<GameRegion> = listOf()

    // TODO Is this long? Last 4 bytes should be nil.
    var nextRefreshDelay: Long = Int.MAX_VALUE.toLong()

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