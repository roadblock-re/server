package moe.crx.roadblock.objects.social

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class SocialRequestList : RObject {

    var requests: List<SocialRequest> = listOf()

    override fun read(sink: InputSink) {
        requests = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(requests)
    }
}