package moe.crx.roadblock.objects.item

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CarClass
import moe.crx.roadblock.objects.game.CarStatType

class RareUpgradeItem : RObject {

    var partType: CarStatType = CarStatType.TopSpeed
    var partClass: CarClass = CarClass.A

    override fun read(sink: InputSink) {
        partType = sink.readEnum()
        partClass = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum(partType)
        sink.writeEnum(partClass)
    }
}