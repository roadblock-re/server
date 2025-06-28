package moe.crx.roadblock.objects.gacha

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class GachaId : RObject {

    var id: Int = 0

    override fun read(sink: InputSink) {
        id = if (sink newer "24.0.0") {
            sink.readInt()
        } else {
            sink.readShort().toInt()
        }
    }

    override fun write(sink: OutputSink) {
        if (sink newer "24.0.0") {
            sink.writeInt(id)
        } else {
            sink.writeShort(id.toShort())
        }
    }
}