package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ClassSpecificFreeUpgrade : RObject {

    var carClass: CarClass = CarClass.A

    override fun read(sink: InputSink) {
        carClass = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum(carClass)
    }
}