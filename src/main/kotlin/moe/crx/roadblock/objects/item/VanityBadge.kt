package moe.crx.roadblock.objects.item

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class VanityBadge : RObject {

    var badgeId: Byte = 0

    override fun read(sink: InputSink) {
        badgeId = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(badgeId)
    }
}