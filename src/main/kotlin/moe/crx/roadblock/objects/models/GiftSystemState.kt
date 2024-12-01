package moe.crx.roadblock.objects.models

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString

class GiftSystemState : RObject {

    var claimedGifts: List<RString> = listOf()

    override fun read(sink: InputSink) {
        claimedGifts = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(claimedGifts)
    }
}