package moe.crx.roadblock.objects.gacha

import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class GachaPoolDataEntry : RObject {

    var data: Map<RInt, RByte> = mapOf()

    override fun read(sink: InputSink) {
        data = sink.readMap()
    }

    override fun write(sink: OutputSink) {
        sink.writeMap(data)
    }

}
