package moe.crx.roadblock.objects.item

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class WildcardBlueprint : RObject {

    // TODO check if it's int or byte
    var carClass: Int = 0

    // TODO check if it's int or byte
    var tier: Byte = 0

    override fun read(sink: InputSink) {
        carClass = sink.readInt()
        tier = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carClass)
        sink.writeByte(tier)
    }
}