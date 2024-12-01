package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ClassAndUnlockedTierSpecificFreeUpgrade : RObject {

    var carClass: CarClass = CarClass.A
    var tier: CarUpgradeTier = 0

    override fun read(sink: InputSink) {
        carClass = sink.readEnum()
        tier = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum(carClass)
        sink.writeByte(tier)
    }
}