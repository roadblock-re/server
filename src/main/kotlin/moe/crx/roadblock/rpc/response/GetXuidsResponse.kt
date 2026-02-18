package moe.crx.roadblock.rpc.response

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.rpc.base.ResponsePacket

class GetXuidsResponse : ResponsePacket() {

    var xuids: List<RString> = listOf() // TODO List of what?

    override fun read(sink: InputSink) {
        super.read(sink)
        xuids = sink.readList()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeList(xuids)
    }
}